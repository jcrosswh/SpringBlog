package us.xwhite.spring.blog.exception;

/**
 *
 * @author Joel
 */
public class AuthorNotFoundException extends RuntimeException {

    private final Long authorId;

    public AuthorNotFoundException(Long authorId) {
        this.authorId = authorId;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
