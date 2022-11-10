package lee.newscriber.sourcefinder;

import lee.newscriber.domain.Article;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.format.DateTimeFormatter;

public class RssHandler extends DefaultHandler {
    private Feed feed;
    private StringBuilder sb;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E',' dd MMM yyyy HH':'mm':'ss Z");

    @Override
    public void startDocument() throws SAXException {
        feed = new Feed();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "item":
                feed.addArticle();
                break;
            case "title":
            case "description":
                sb = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "title":
                if (feed.getArticles().size() == 0) {
                    break;
                }
                Article latest = feed.getLatestArticle().orElseThrow(IllegalArgumentException::new);
                latest.setTitle(sb.toString());
                break;
            case "description":
                if (feed.getArticles().size() == 0) {
                    break;
                }
                latest = feed.getLatestArticle().orElseThrow(IllegalArgumentException::new);
                latest.setContent(sb.toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (sb == null) {
            sb = new StringBuilder();
        } else {
            sb.append(ch, start, length);
        }
    }

    public Feed getFeed() {
        return feed;
    }
}
