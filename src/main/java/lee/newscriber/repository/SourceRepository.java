package lee.newscriber.repository;

import lee.newscriber.domain.Article;
import lee.newscriber.domain.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {
    List<Source> getSourceList();

    List<Article> getArticlesFrom(long sourceId);
}
