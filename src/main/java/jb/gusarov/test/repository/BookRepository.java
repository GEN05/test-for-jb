package jb.gusarov.test.repository;

import jb.gusarov.test.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByCreationTimeDesc();

    Book findById(long id);

    Book findByCipher(long cipher);

    @Modifying
    @Query("delete from Book book where book.cipher=:cipher")
    void deleteBooks(@Param("cipher") long cipher);

    @Transactional
    @Modifying
    @Query(value = "UPDATE book set cipher=?2 where cipher=?1", nativeQuery = true)
    void updateCipher(long cipher, long newCipher);
}