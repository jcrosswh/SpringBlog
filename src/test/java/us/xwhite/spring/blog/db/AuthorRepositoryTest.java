package us.xwhite.spring.blog.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void findByEmailTest() {
        assertEquals("Joel", authorRepository.findByEmail("joel.crosswhite@xwhite.us").getFirstName());
        assertNull(authorRepository.findByEmail("not.here@com.com"));
    }
}
