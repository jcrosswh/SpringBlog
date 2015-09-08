package us.xwhite.spring.blog.db;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import us.xwhite.spring.blog.domain.Article;
import us.xwhite.spring.blog.domain.Author;

/**
 *
 * @author Joel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:blog/db/jpa/RepositoryTest-context.xml")
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    @Transactional
    public void testCount() {
        assertEquals(15, articleRepository.count());
    }

    @Test
    @Transactional
    public void findOne() {
        Article thirteen = articleRepository.findOne(13);
        assertEquals(13, (long) thirteen.getId());
        assertEquals("Lucky #13", thirteen.getTitle());
        assertEquals("Now I know why skyscrapers skip this floor.", thirteen.getContent());
        assertEquals(1, (long) thirteen.getAuthor().getId());
        assertEquals("Joel", thirteen.getAuthor().getFirstName());
        assertEquals("Crosswhite", thirteen.getAuthor().getLastName());
        assertEquals("joel.crosswhite@xwhite.us", thirteen.getAuthor().getEmail());
        assertEquals("8005551212", thirteen.getAuthor().getPhone());
        assertEquals(2, thirteen.getTags().size());
        assertEquals("miscelaneous", thirteen.getTags().get(1).getName());
    }

    @Test
    @Transactional
    public void findAll() {
        List<Article> allArticles = articleRepository.findAll();
        assertEquals(15, allArticles.size());
        for (int i = 0; i < allArticles.size(); i++) {
            assertEquals((long) (i + 1), (long) allArticles.get(i).getId());
        }
    }

    @Test
    @Transactional
    public void save() {
        assertEquals(15, articleRepository.count());
        Author author = articleRepository.findOne(13).getAuthor();
        Article article = new Article("What I Learned in Java Today", "Java so rocks!", author, null);
        Article saved = articleRepository.save(article);
        assertEquals(16, articleRepository.count());
        assertNewArticle(saved);
        assertNewArticle(articleRepository.findOne(16L));
    }

    private void assertNewArticle(Article article) {
        assertEquals(16, (long) article.getId());
    }

}
