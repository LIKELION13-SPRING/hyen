package me.hyen.springboot_developer.controller;

import lombok.RequiredArgsConstructor;
import me.hyen.springboot_developer.domain.Article;
import me.hyen.springboot_developer.dto.AddArticleRequest;
import me.hyen.springboot_developer.dto.ArticleResponse;
import me.hyen.springboot_developer.dto.UpdateArticleRequest;
import me.hyen.springboot_developer.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    // HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    // @RequestBody로 요청 본문값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    // URL 경로에서 값 추출
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable("id") long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id,
                                                 @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle); // 응답 값 바디에 담아 전송
    }

}
