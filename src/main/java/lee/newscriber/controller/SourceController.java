package lee.newscriber.controller;

import lee.newscriber.service.SourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sources")
public class SourceController {
    private final SourceService sourceService;

    @GetMapping
    public ResponseStatus<ArticleListResponse> loadSourceList() {
        return sourceService.loadSourceList();
    }

    @GetMapping("/{sourceId}")
    public ResponseEntity<ArticleListResponse> loadArticlesFromSource(@PathVariable long sourceId) {
        return sourceService.loadArticleFromSource(sourceId);
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
