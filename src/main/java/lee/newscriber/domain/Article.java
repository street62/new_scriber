package lee.newscriber.domain;

import java.time.LocalDateTime;

public class Article {
    private long articleId;
    private long sourceId;
    private String url;
    private String title;
    private String content;

    public Article(long sourceId, String title, String content) {
        this.sourceId = sourceId;
        this.title = title;
        this.content = content;
    }
}
