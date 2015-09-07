package us.xwhite.spring.blog.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import us.xwhite.spring.blog.domain.Author;

/**
 *
 * @author Joel
 */
@Repository
public class AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public Author save(Author author) {
        entityManager.persist(author);
        return author;
    }

    public Author findOne(long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll() {
        return (List<Author>) entityManager.createQuery("select s from Author s").getResultList();
    }
}
