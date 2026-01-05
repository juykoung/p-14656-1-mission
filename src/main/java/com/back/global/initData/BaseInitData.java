package com.back.global.initData;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 어노테이션으로 설정 클래스 지정
@Slf4j
@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;

    @Bean
    public ApplicationRunner baseInitDataRunner() {
        // ApplicationRunner : Bean을 통해 애플리케이션 시작 시 초기화 로직 실행
        return args -> {
            work1();
        };
    }

    private void work1() {
        log.debug("Post entity 개수: {}", postService.count());
        if (postService.count() == 0) {
            for (int i = 1; i <= 10; i++) {
                String title = "Sample Post Title " + i;
                String content = "This is the content of sample post number " + i + ".";
                String author = "Author" + i;
                Post post = postService.create(title, content, author);
                log.debug("Created Post: {}", post);
            }
        }
    }
}