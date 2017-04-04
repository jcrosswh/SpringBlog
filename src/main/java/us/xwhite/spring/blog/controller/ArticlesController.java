package us.xwhite.spring.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import us.xwhite.spring.blog.db.ArticleRepository;
import us.xwhite.spring.blog.domain.Article;
import us.xwhite.spring.blog.exception.ArticleNotFoundException;

/**
 *
 * @author Joel
 */
@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Article getOneArticle(@PathVariable("id") Long id) {
        Article retval = articleRepository.findOne(id);
        if (retval == null) {
            throw new ArticleNotFoundException(id);
        }
        return retval;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article, UriComponentsBuilder ucb) {

        Article savedArticle = articleRepository.save(article);
        return ResponseEntity.created(ucb.path("/articles/").path(String.valueOf(savedArticle.getId())).build().toUri()).body(savedArticle);
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error articleNotFound(ArticleNotFoundException e) {
        Long articleId = e.getArticleId();
        return new Error("Article [" + articleId.toString() + "] not found");
    }
}
