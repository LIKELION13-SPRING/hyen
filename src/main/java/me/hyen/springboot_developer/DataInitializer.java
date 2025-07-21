package me.hyen.springboot_developer;

import lombok.RequiredArgsConstructor;
import me.hyen.springboot_developer.domain.Article;
import me.hyen.springboot_developer.repository.BlogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BlogRepository blogRepository;

    @Override
    public void run(String... args) {
        blogRepository.save(new Article("제목 1", "내용 1"));
        blogRepository.save(new Article("제목 2", "내용 2"));
        blogRepository.save(new Article("제목 3", "내용 3"));
    }
}
// 샤갈 .sql쓰기 절대 불가 왜 나만 안됨?
