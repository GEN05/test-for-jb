package jb.gusarov.test.service;

import jb.gusarov.test.domain.Book;
import jb.gusarov.test.domain.User;
import jb.gusarov.test.form.BookForm;
import jb.gusarov.test.form.UserCredentials;
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

    public Book register(BookForm bookForm) {
        Book book = new Book();
        book.setTitle(bookForm.getTitle());
        book.setAuthor(bookForm.getAuthor());
        bookRepository.save(book);
        return book;
    }
}