package lee.newscriber.service;

import lee.newscriber.domain.Article;
import lee.newscriber.domain.Source;
import lee.newscriber.dto.NewSourceRequest;
import lee.newscriber.repository.SourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SourceService {
    SourceRepository sourceRepository;
    public ResponseStatus addNewSource(NewSourceRequest newSourceRequest) {
//        String url = newSourceRequest.getUrl();
//        SourceType type = newSourceRequest.getSourceType();
//
//        ArrayList<SourceSampleData> sourceSampleData = newSourceRequest.getSampleData();

    }

    public ResponseEntity<List<Source>> loadSourceList() {
        sourceRepository.getSourceList();
    }

    public ResponseEntity<List<Article>> loadArticlesFrom(long sourceId) {
        updateSource(sourceId);
        sourceRepository.getArticlesFrom(sourceId);
    }

    private void updateSource(long sourceId) throws IOException {
//        Source source = sourceRepository.getSource(sourceId);
        List<String> urlList = new ArrayList<>();
        Connection conn = Jsoup.connect("https://keepseeking.tistory.com/");
        Document document = conn.get();
        Elements titleElements = document.getElementsByClass("title-post");
        for (Element element : titleElements) {
            System.out.println(element);
        }
    }


    public ResponseStatus deleteSource(long sourceId) {
        return null;
    }
}
