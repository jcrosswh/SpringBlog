package us.xwhite.spring.blog.db;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        List<Article> articles = articleRepository.findAllByTitle("Lucky #13");
        assertEquals(1, articles.size());
        Article thirteen = articleRepository.findById(articles.get(0).getId()).get();
        assertEquals(articles.get(0).getId(), thirteen.getId());
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
        allArticles.forEach((article) -> {
            assertNotNull(article);
        });
    }

    @Test
    @Transactional
    public void save() {
        assertEquals(15, articleRepository.count());
        Author author = articleRepository.findAllByTitle("Lucky #13").get(0).getAuthor();
        Article article = new Article(16L, "What I Learned in Java Today", "Java so rocks!", author, null);
        Article saved = articleRepository.save(article);
        assertEquals(16, articleRepository.count());
    }

    @Test
    @Transactional
    public void paginate() {
        assertEquals(15, articleRepository.count());
        Page<Article> articles = articleRepository.findAll(new PageRequest(1, 5, Sort.unsorted()) {
        });
        assertEquals(5, articles.getSize());
    }

    @Test
    @Transactional
    public void findAllByTitle() {
        assertEquals(15, articleRepository.count());

        // Case sensitive 
        List<Article> allArticles = articleRepository.findAllByTitle("What");
        assertEquals(3, allArticles.size());
        
        allArticles = articleRepository.findAllByTitle("what");
        assertEquals(0, allArticles.size());
    }

}
