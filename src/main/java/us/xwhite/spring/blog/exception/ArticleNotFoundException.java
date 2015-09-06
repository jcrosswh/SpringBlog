package us.xwhite.spring.blog.exception;

/**
 *
 * @author Joel
 */
public class ArticleNotFoundException extends RuntimeException {

    private final Long articleId;

    public ArticleNotFoundException(Long articleId) {
        this.articleId = articleId;
    }

    public Long getArticleId() {
        return articleId;
    }
}
