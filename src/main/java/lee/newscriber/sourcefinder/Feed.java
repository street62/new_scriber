package lee.newscriber.sourcefinder;

import lee.newscriber.domain.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Feed {
    private final List<Article> articles = new ArrayList<>();

    public void addArticle() {
        articles.add(new Article());
    }

    public Optional<Article> getLatestArticle() {
        return Optional.of(articles.get(articles.size() - 1));
    }

    public List<Article> getArticles() {
        return new ArrayList<>(articles);
    }
}
