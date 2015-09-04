package us.xwhite.spring.blog.controller;

import java.util.ArrayList;
import java.util.List;
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
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Article> getAllArticles() {
        return new ArrayList<>();
    }
}
