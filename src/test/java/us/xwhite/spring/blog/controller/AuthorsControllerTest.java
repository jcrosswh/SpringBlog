package us.xwhite.spring.blog.controller;

import java.util.ArrayList;
import java.util.List;
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
import us.xwhite.spring.blog.db.AuthorRepository;
import us.xwhite.spring.blog.domain.Author;
import us.xwhite.test.TestUtil;
import static us.xwhite.test.TestUtil.APPLICATION_JSON_UTF8;

/**
 *
 * @author Joel
 */
public class AuthorsControllerTest {

    @Test
    public void getAllAuthors() throws Exception {

        List<Author> expectedList = new ArrayList<>();
        Author author1 = new Author("Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212");
        Author author2 = new Author("Chuck", "Wagon", "chuck.wagon@xwhite.us ", "8005551212");
        expectedList.add(author1);
        expectedList.add(author2);
        AuthorRepository mockRepository = mock(AuthorRepository.class);
        when(mockRepository.findAll()).thenReturn(expectedList);

        AuthorsController controller = new AuthorsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/authors").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is("Joel")))
                .andExpect(jsonPath("$[1].firstName", is("Chuck")));
    }

    @Test
    public void getOneAuthor_SuccessfulFind() throws Exception {

        Author expectedAuthor = new Author("Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212");
        AuthorRepository mockRepository = mock(AuthorRepository.class);
        when(mockRepository.findOne(1)).thenReturn(expectedAuthor);

        AuthorsController controller = new AuthorsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/authors/1").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.firstName", is("Joel")));
    }

    @Test
    public void getOneAuthor_NoFind() throws Exception {

        AuthorRepository mockRepository = mock(AuthorRepository.class);
        when(mockRepository.findOne(1)).thenReturn(null);

        AuthorsController controller = new AuthorsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/authors/1").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.message", is("Author [1] not found")));
    }

    @Test
    public void saveAuthor() throws Exception {
        Author author = new Author("Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212");
        Author expectedAuthor = new Author(1L, "Joel", "Crosswhite", "joel.crosswhite@xwhite.us ", "8005551212");
        AuthorRepository mockRepository = mock(AuthorRepository.class);
        when(mockRepository.save(author)).thenReturn(expectedAuthor);

        AuthorsController controller = new AuthorsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/authors").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.objectToJson(author))
        )
                // .andDo(print())
                // not sure if having 'localhost' makes this fragile or not - leaving it in for now
                .andExpect(redirectedUrl("http://localhost/authors/1"));

        verify(mockRepository, atLeastOnce()).save(author);
    }

    @Test
    public void badURI() throws Exception {

        AuthorRepository mockRepository = mock(AuthorRepository.class);

        AuthorsController controller = new AuthorsController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/just_not_here").accept(MediaType.APPLICATION_JSON))
                // .andDo(print())
                .andExpect(status().isNotFound());
    }
}
