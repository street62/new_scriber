package lee.newscriber.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Source {
    @Id
    @Column(name = "SOURCE_ID")
    private long id;
    private String title;
    private String url;
    private String titleTag;
    private String contentTag;
    @OneToMany(mappedBy = "article")
    private List<Article> articles = new ArrayList<>();
}
