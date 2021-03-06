package us.xwhite.spring.blog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import us.xwhite.spring.blog.db.ArticleRepository;
import us.xwhite.spring.blog.domain.Article;
import us.xwhite.spring.blog.domain.Author;
import us.xwhite.spring.blog.domain.Tag;
import us.xwhite.test.TestUtil;

/**
 *
 * @author Joel
 */
public class ArticlesControllerTest {

    @Test
    public void getAllArticles() throws Exception {

        List<Article> expectedList = new ArrayList<>();
        Author author = new Author("Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212");
        Article article1 = new Article("Brand New Article", "Writing it up!!", author, null);
        Article article2 = new Article("Second Article", "Here's what's going on.", author, null);
        expectedList.add(article1);
        expectedList.add(article2);
        ArticleRepository mockRepository = mock(ArticleRepository.class);
        when(mockRepository.findAll()).thenReturn(expectedList);

        ArticlesController controller = new ArticlesController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/articles").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Brand New Article")))
                .andExpect(jsonPath("$[1].title", is("Second Article")));
    }

    @Test
    public void getOneArticle_SuccessfulFind() throws Exception {

        Article expectedArticle = new Article("Brand New Article", "Writing it up!!", new Author("Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212"
        ), null);
        ArticleRepository mockRepository = mock(ArticleRepository.class);
        when(mockRepository.findById(17L)).thenReturn(Optional.of(expectedArticle));

        ArticlesController controller = new ArticlesController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/articles/17").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("Brand New Article")));
    }

    @Test
    public void getOneArticle_NoFind() throws Exception {

        ArticleRepository mockRepository = mock(ArticleRepository.class);
        when(mockRepository.findById(17L)).thenReturn(Optional.empty());

        ArticlesController controller = new ArticlesController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/articles/17").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Article [17] not found")));
    }

    @Test
    public void saveArticle() throws Exception {
        List<Tag> newTag = new ArrayList<>();
        newTag.add(new Tag("brand-new-article"));
        Article article = new Article("Brand New Article", "Writing it up!!", new Author("Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212"
        ), newTag);
        Article expectedArticle = new Article(1L, "Brand New Article", "Writing it up!!", new Author("Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212"
        ), newTag);
        ArticleRepository mockRepository = mock(ArticleRepository.class);
        when(mockRepository.save(article)).thenReturn(expectedArticle);

        ArticlesController controller = new ArticlesController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/articles").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.objectToJson(article))
        )
                // .andDo(print())
                // not sure if having 'localhost' makes this fragile or not - leaving it in for now
                .andExpect(redirectedUrl("http://localhost/articles/1"));

        verify(mockRepository, atLeastOnce()).save(article);
    }

    @Test
    public void badURI() throws Exception {

        ArticleRepository mockRepository = mock(ArticleRepository.class);

        ArticlesController controller = new ArticlesController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/just_not_here").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isNotFound());
    }
}
