package us.xwhite.spring.blog.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import us.xwhite.spring.blog.domain.Tag;

/**
 *
 * @author Joel
 */
@Repository
public class TagRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public Tag save(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    public Tag findOne(long id) {
        return entityManager.find(Tag.class, id);
    }

    public List<Tag> findAll() {
        return (List<Tag>) entityManager.createQuery("select s from Tag s").getResultList();
    }
}
