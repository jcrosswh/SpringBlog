package us.xwhite.spring.blog.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import us.xwhite.spring.blog.db.AuthorRepository;
import us.xwhite.spring.blog.domain.Author;
import us.xwhite.spring.blog.exception.AuthorNotFoundException;

/**
 *
 * @author Joel
 */
@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author getOneAuthor(@PathVariable("id") Long id) {
        Author retval = authorRepository.findOne(id);
        if (retval == null) {
            throw new AuthorNotFoundException(id);
        }
        return retval;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author, UriComponentsBuilder ucb) {

        Author savedAuthor = authorRepository.save(author);
        HttpHeaders headers = new HttpHeaders();
        URI locationUri
                = ucb.path("/authors/")
                .path(String.valueOf(savedAuthor.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);
        ResponseEntity<Author> responseEntity
                = new ResponseEntity<>(
                        savedAuthor, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error authorNotFound(AuthorNotFoundException e) {
        Long authorId = e.getAuthorId();
        return new Error("Author [" + authorId.toString() + "] not found");
    }
}