package lee.newscriber.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Source {
    @Id
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;
    private String baseUrl;
    private String titleTag;
    private String contentTag;
    private String dateTag; // 추후 값 타입으로 수정
    @OneToMany(mappedBy = "article")
    private List<Article> articles = new ArrayList<>();
}
