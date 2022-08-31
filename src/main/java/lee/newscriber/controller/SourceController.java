package lee.newscriber.controller;

import lee.newscriber.domain.Article;
import lee.newscriber.domain.Source;
import lee.newscriber.dto.GeneralResponseDto;
import lee.newscriber.dto.source.ArticleListResponse;
import lee.newscriber.dto.source.NewSourceRequest;
import lee.newscriber.dto.source.SourceListResponse;
import lee.newscriber.dto.source.SourceUpdateRequest;
import lee.newscriber.service.SourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sources")
public class SourceController {
    private final SourceService sourceService;

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @PostMapping
    public ResponseEntity<GeneralResponseDto> addSource(@RequestBody NewSourceRequest request) {
        sourceService.addNewSource(request);
        return ResponseEntity.ok(new GeneralResponseDto(200, "구독 소스가 추가되었습니다."));
    }

    @GetMapping
    public ResponseEntity<SourceListResponse> loadSourceList() {
        List<Source> sources = sourceService.loadSourceList();
        return ResponseEntity.ok(SourceListResponse.from(sources));
    }

    @GetMapping("/{sourceId}")
    public ResponseEntity<ArticleListResponse> loadArticlesFrom(@PathVariable Long sourceId) {
        List<Article> articles = sourceService.loadArticlesFrom(sourceId);
        return ResponseEntity.ok(ArticleListResponse.from(articles));
    }

    @PatchMapping("/{sourceId}")
    public ResponseEntity<GeneralResponseDto> updateSourceInfo(@PathVariable Long sourceId, @RequestBody SourceUpdateRequest request) {
        sourceService.updateSourceInfo(request);
        return ResponseEntity.ok(new GeneralResponseDto(200, "Source 정보가 수정되었습니다."));
    }

    @DeleteMapping("/{sourceId}")
    public ResponseEntity<GeneralResponseDto> deleteSource(@PathVariable long sourceId) {
        sourceService.deleteSource(sourceId);
        return ResponseEntity.ok(new GeneralResponseDto(200, "소스가 삭제되었습니다."));
    }
}
