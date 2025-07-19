package me.hyen.springboot_developer.service;

import lombok.RequiredArgsConstructor;
import me.hyen.springboot_developer.domain.Article;
import me.hyen.springboot_developer.dto.AddArticleRequest;
import me.hyen.springboot_developer.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 매서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
