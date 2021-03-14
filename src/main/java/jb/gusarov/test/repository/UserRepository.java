package jb.gusarov.test.repository;

import jb.gusarov.test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET passwordSha=SHA1(CONCAT('1be3db47a7684152', ?2)) WHERE id=?1", nativeQuery = true)
    void updatePasswordSha(long id, String password);

    @Query(value = "SELECT * FROM user WHERE name=?1 AND surname=?2 AND passwordSha=SHA1(CONCAT('1be3db47a7684152', ?3))", nativeQuery = true)
    User findByNameAndSurnameAndPassword(String name, String surname, String password);

    List<User> findAllByOrderByIdDesc();
}