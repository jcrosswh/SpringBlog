package us.xwhite.spring.blog.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import us.xwhite.spring.blog.domain.Article;

/**
 *
 * @author Joel
 */
@Repository
public class ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public Article save(Article article) {
        entityManager.persist(article);
        return article;
    }

    public Article findOne(long id) {
        return entityManager.find(Article.class, id);
    }

    public List<Article> findAll() {
        return (List<Article>) entityManager.createQuery("select s from Article s").getResultList();
    }
}
