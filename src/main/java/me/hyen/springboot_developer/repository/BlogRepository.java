package me.hyen.springboot_developer.repository;

import me.hyen.springboot_developer.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
