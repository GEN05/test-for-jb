package jb.gusarov.test.service;

import jb.gusarov.test.domain.Book;
import jb.gusarov.test.domain.User;
import jb.gusarov.test.form.UserBookForm;
import jb.gusarov.test.form.UserCredentials;
import jb.gusarov.test.repository.BookRepository;
import jb.gusarov.test.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;


    public CommonService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public User register(UserCredentials userCredentials) {
        User user = new User();
        user.setName(userCredentials.getName());
        user.setSurname(userCredentials.getSurname());
        userRepository.save(user);
        userRepository.updatePasswordSha(user.getId(), userCredentials.getPassword());
        return user;
    }

    public void addUserAndBook(User user, UserBookForm userBookForm) {
        Book book = bookRepository.findByCipher(userBookForm.getCipher());
        book.addUser(user);
        userRepository.save(user);
    }
}