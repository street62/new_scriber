package lee.newscriber.sourcefinder;

import lee.newscriber.domain.Article;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class RssParserTest {
    @Test
    public void parserTest() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        RssHandler handler = new RssHandler();
        parser.parse("/Users/kylechoi/Downloads/rss.rss", handler);

        Feed feed = handler.getFeed();
        List<Article> articles = feed.getArticles();

        for (Article article : articles) {
            System.out.println(article.getTitle());
        }
    }

    @Test
    public void dateTimeFormatterTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E',' dd MMM yyyy HH':'mm':'ss xx");
        DateTimeFormatter formatterTwo = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss xx");
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now.format(formatterTwo));

        ZonedDateTime time = ZonedDateTime.parse("Tue, 08 Nov 2022 15:36:24 +0900", formatter);
        System.out.println(time.format(formatter));
    }
}