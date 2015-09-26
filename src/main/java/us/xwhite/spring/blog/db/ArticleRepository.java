package us.xwhite.spring.blog.db;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.xwhite.spring.blog.domain.Article;

/**
 *
 * @author Joel
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
