package us.xwhite.spring.blog.db;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import us.xwhite.spring.blog.domain.Author;

/**
 *
 * @author Joel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:blog/db/jpa/RepositoryTest-context.xml")
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    @Transactional
    public void testCount() {
        assertEquals(2, authorRepository.count());
    }

    @Test
    @Transactional
    public void findOne() {
        Author me = authorRepository.findOne(2);
        assertEquals(2, (long) me.getId());
        assertEquals("Chuck", me.getFirstName());
        assertEquals("Wagon", me.getLastName());
        assertEquals("chuck.wagon@xwhite.us", me.getEmail());
        assertEquals("8005551212", me.getPhone());
        assertEquals(3, me.getArticles().size());
    }

    @Test
    @Transactional
    public void findAll() {
        List<Author> allAuthors = authorRepository.findAll();
        assertEquals(2, allAuthors.size());
        for (int i = 0; i < allAuthors.size(); i++) {
            assertEquals((long) (i + 1), (long) allAuthors.get(i).getId());
        }
    }

    @Test
    @Transactional
    public void save() {
        assertEquals(2, authorRepository.count());
        Author author = new Author("Mickey", "Mantle", "mickey.mantle@xwhite.us", "8005551212");
        Author saved = authorRepository.save(author);
        assertEquals(3, authorRepository.count());
        assertEquals(3, (long) saved.getId());
        assertEquals(3, (long) authorRepository.findOne(3L).getId());
    }
}
