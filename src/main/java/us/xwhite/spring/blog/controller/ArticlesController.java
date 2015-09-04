package us.xwhite.spring.blog.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import us.xwhite.spring.blog.domain.Article;

/**
 *
 * @author Joel
 */
@RestController
@RequestMapping("/articles")
public class ArticlesController {
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Article> getAllArticles() {
        return new ArrayList<>();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Article getOneArticle(@PathVariable("id") Long id) {
        Article retval = new Article();
        retval.setId(id);
        return retval;
    }
}
