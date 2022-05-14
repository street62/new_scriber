package lee.newscriber.controller;

import lee.newscriber.domain.Article;
import lee.newscriber.domain.Source;
import lee.newscriber.service.SourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sources")
public class SourceController {
    private final SourceService sourceService;

    @GetMapping
    public ResponseEntity<List<Source>> loadSourceList() {
        return sourceService.loadSourceList();
    }

    @GetMapping("/{sourceId}")
    public ResponseEntity<List<Article>> loadArticlesFrom(@PathVariable long sourceId) {
        return sourceService.loadArticlesFrom(sourceId);
    }

    @DeleteMapping("/{sourceId}")
    public ResponseStatus deleteSource(@PathVariable long sourceId) {
        return sourceService.deleteSource(sourceId);
    }

    @PostMapping
    public ResponseStatus addNewSource(@RequestBody NewSourceRequest newSourceRequest) {
        return sourceService.addNewSource(NewSourceRequest);
    }
}
