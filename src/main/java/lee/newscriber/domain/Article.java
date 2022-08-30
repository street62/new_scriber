package lee.newscriber.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {
    @Id @GeneratedValue
    private long articleId;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;
    private String url;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Boolean isRead;

    public Article() {

    }
    public Article(Source source, String title, String content) {
        this.source = source;
        this.title = title;
        this.content = content;
    }
}
