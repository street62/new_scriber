package lee.newscriber.service;

import lee.newscriber.domain.Article;
import lee.newscriber.domain.Source;
import lee.newscriber.dto.NewSourceRequest;
import lee.newscriber.repository.ArticleRepository;
import lee.newscriber.repository.SourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
//@RequiredArgsConstructor
@Service
public class SourceService {
    private final SourceRepository sourceRepository;
    private final ArticleRepository articleRepository;

    public SourceService(SourceRepository sourceRepository, ArticleRepository articleRepository) {
        this.sourceRepository = sourceRepository;
        this.articleRepository = articleRepository;
    }

    public ResponseStatus addNewSource(NewSourceRequest newSourceRequest) {
//        String url = newSourceRequest.getUrl();
//        SourceType type = newSourceRequest.getSourceType();
//
//        ArrayList<SourceSampleData> sourceSampleData = newSourceRequest.getSampleData();
        return null;
    }

    public ResponseEntity<List<Source>> loadSourceList() {
        sourceRepository.getSourceList();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<List<Article>> loadArticlesFrom(long sourceId) throws IOException {
        updateSource(sourceId);
        sourceRepository.getArticlesFrom(sourceId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void updateSource(long sourceId) throws IOException {
//        Source source = sourceRepository.getSource(sourceId);
        List<String> urlList = new ArrayList<>();
        Connection conn = Jsoup.connect("https://keepseeking.tistory.com/");
        Document document = conn.get();
        Elements titles = document.getElementsByClass("title_post");
        Article latestArticle = articleRepository.getLatestArticle(sourceId);
        for (Element title : titles) {
//            if (title.text().equals(latestArticle.getTitle())) {
//                break;
//            }
            Element elementsContainingTitle = document.getElementsContainingOwnText(title.text()).first().parent();
            System.out.println(elementsContainingTitle);
//            Article newArticle = new Article(sourceId, title);

        }
    }


    public ResponseStatus deleteSource(long sourceId) {
        return null;
    }
}
