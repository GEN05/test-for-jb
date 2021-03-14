package jb.gusarov.test.service;

import jb.gusarov.test.domain.Book;
import jb.gusarov.test.domain.User;
import jb.gusarov.test.form.BookForm;
import jb.gusarov.test.form.UserCredentials;
import jb.gusarov.test.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(UserCredentials userCredentials) {
        User user = new User();
        user.setName(userCredentials.getName());
        user.setSurname(userCredentials.getSurname());
        userRepository.save(user);
        userRepository.updatePasswordSha(user.getId(), userCredentials.getPassword());
        return user;
    }

    public User findByNameAndSurnameAndPassword(String name, String surname, String password) {
        User user = userRepository.findByNameAndSurnameAndPassword(name, surname, password);
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        return name == null || surname == null || password == null ? null : userRepository.findByNameAndSurnameAndPassword(name, surname, password);
    }

    public User findById(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public void addBook(User user, BookForm bookForm) {
        Book book = new Book();
        book.addUser(user);
        book.setTitle(bookForm.getTitle());
        book.setAuthor(bookForm.getAuthor());
        user.addBook(book);
        userRepository.save(user);
    }
}