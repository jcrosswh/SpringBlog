package us.xwhite.spring.blog.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import us.xwhite.spring.blog.domain.Author;

/**
 *
 * @author Joel
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM AUTHORS a WHERE a.email = :email")
    public Author findByEmail(@Param("email") String email);
}
