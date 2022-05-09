package lee.newscriber.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/source")
public class SourceController {
    private final SourceService sourceService;

    @GetMapping("/{sourceId}")
    public ResponseEntity<ArticleListResponse> loadArticlesFromSource(@PathVariable long sourceId) {
        return sourceService.loadArticleFromSource(sourceId);
    }

    @GetMapping("/{sourceId}/refresh")
    public ResponseEntity<ArticleListResponse> refreshSource(@PathVariable long sourceId) {
        return loadArticlesFromSource(sourceId);
    }

    @PostMapping("/add")
    public ResponseStatus addNewSource(@RequestBody NewSourceRequest newSourceRequest) {
        return sourceService.addNewSource(NewSourceRequest);
    }
}
