package io.factorialsystems.store.web.controller.blog;


import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.blog.PostService;
import io.factorialsystems.store.web.mapper.blog.PostMSMapper;
import io.factorialsystems.store.web.model.blog.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store/posts")
public class PostController {
    private final PostService postService;
    private final PostMSMapper postMSMapper;

    @GetMapping("/byproduct/{id}")
    public ResponseEntity <List<PostDto>>findProductPosts(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(postMSMapper.ListPostToPostDto(postService.findPostByProductId(id)), HttpStatus.OK);
    }

    @GetMapping("/bypost/{id}")
    public ResponseEntity <PostDto>findPostsById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(postMSMapper.PostToPostDto(postService.findPostById(id)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @Valid @RequestBody PostDto postDto) {
        MessageResponse messageResponse;
        HttpStatus httpStatus = HttpStatus.OK;

        if (postService.update(id, postDto)) {
            messageResponse = new MessageResponse("Post updated Successfully");
        } else {
            messageResponse = new MessageResponse("Post update Error");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(messageResponse, httpStatus);
    }

    @PostMapping("/")
    public ResponseEntity<PostDto> save(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.save(postDto), HttpStatus.CREATED);
    }

}
