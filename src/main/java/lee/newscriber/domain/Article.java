package lee.newscriber.domain;

import com.apptasticsoftware.rssreader.Item;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Article {
    @Id @GeneratedValue
    private long articleId;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;
    private String url;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private ZonedDateTime createdAt;
    private boolean isRead;

    public static Article of(Item item, Source source) {
        final String UNKNOWN_STRING = "unknown";

        return Article.builder()
                .source(source)
                .url(item.getLink().orElse(UNKNOWN_STRING))
                .title(item.getTitle().orElse(UNKNOWN_STRING))
                .content(item.getDescription().orElse(UNKNOWN_STRING))
                .createdAt(item.getPubDateZonedDateTime().orElse(ZonedDateTime.now()))
                .isRead(false)
                .build();
    }

}
