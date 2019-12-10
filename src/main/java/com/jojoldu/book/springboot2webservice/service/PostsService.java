package com.jojoldu.book.springboot2webservice.service;

import com.jojoldu.book.springboot2webservice.domain.posts.Posts;
import com.jojoldu.book.springboot2webservice.domain.posts.PostsRepository;
import com.jojoldu.book.springboot2webservice.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot2webservice.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot2webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestsDto) {
        return  postsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
