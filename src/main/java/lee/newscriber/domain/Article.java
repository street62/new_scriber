package lee.newscriber.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {
    @Id @GeneratedValue
    private long articleId;
    @ManyToOne
    @JoinColumn(name = "SOURCE_ID")
    private Source source;
    private String url;
    private String title;
    private String content;

    public Article() {

    }
    public Article(Source source, String title, String content) {
        this.source = source;
        this.title = title;
        this.content = content;
    }
}
