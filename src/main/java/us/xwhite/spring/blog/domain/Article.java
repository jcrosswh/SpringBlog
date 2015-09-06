package us.xwhite.spring.blog.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "ARTICLES")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Article() {
    }

    public Article(String title, String content, Author author, List<Tag> tags) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.tags = tags;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "ARTICLES_TAGS",
            joinColumns = {
                @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "TAG_ID", referencedColumnName = "ID")})
    private List<Tag> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
