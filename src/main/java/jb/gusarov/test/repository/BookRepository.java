package jb.gusarov.test.repository;

import jb.gusarov.test.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByCreationTimeDesc();

    Book findById(long id);
}