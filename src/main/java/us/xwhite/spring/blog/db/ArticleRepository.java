package us.xwhite.spring.blog.db;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import us.xwhite.spring.blog.domain.Article;

/**
 *
 * @author Joel
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT s FROM Article s WHERE s.title LIKE %:searchTerm%")
    public List<Article> findAllByTitle(@Param("searchTerm") String searchTerm);
}
