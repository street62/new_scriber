package lee.newscriber.service;

import lee.newscriber.domain.Article;
import lee.newscriber.domain.Source;
import lee.newscriber.dto.source.NewSourceRequest;
import lee.newscriber.dto.source.SourceUpdateRequest;
import lee.newscriber.repository.ArticleRepository;
import lee.newscriber.repository.SourceRepository;
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

    public List<Source> loadSourceList() {
        return sourceRepository.getSourceList();
    }

    public List<Article> loadArticlesFrom(long sourceId) {
        updateSource(sourceId);
        return sourceRepository.getArticlesFrom(sourceId);
    }

    private void updateSource(long sourceId) {

    }



    public ResponseStatus deleteSource(long sourceId) {
        return null;
    }

    public void updateSourceInfo(SourceUpdateRequest request) {
    }

}
