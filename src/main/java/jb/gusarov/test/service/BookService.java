package jb.gusarov.test.service;

import jb.gusarov.test.domain.Book;
import jb.gusarov.test.domain.User;
import jb.gusarov.test.form.BookForm;
import jb.gusarov.test.form.UserBookForm;
import jb.gusarov.test.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAllByOrderByCreationTimeDesc();
    }

    public Book find(long id) {
        return bookRepository.findById(id);
    }

    public void register(BookForm bookForm) {
        Book book = new Book();
        book.setTitle(bookForm.getTitle());
        book.setAuthor(bookForm.getAuthor());
        book.setCipher(bookForm.getCipher());
        bookRepository.save(book);
    }

    public void delete(UserBookForm userBookForm) {
        bookRepository.deleteBooks(userBookForm.getCipher());
    }

    public void addUser(User user, Book book) {
        user.addBook(book);
        user.setSurname(user.getSurname());
        user.setName(user.getName());
        book.addUser(user);
        bookRepository.save(book);
    }

    public Book findByCipher(long cipher) {
        return bookRepository.findByCipher(cipher);
    }

    public void changeCipher(long cipher, long newCipher) {
        bookRepository.updateCipher(cipher, newCipher);
    }
}