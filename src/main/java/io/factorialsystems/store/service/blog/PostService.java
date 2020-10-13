package io.factorialsystems.store.service.blog;

import io.factorialsystems.store.domain.blog.Post;
import io.factorialsystems.store.mapper.blog.PostMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.web.mapper.blog.PostMSMapper;
import io.factorialsystems.store.web.model.blog.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    private final PostMSMapper postMSMapper;

    public List<Post> findPostByProductId(Integer id) {
        return postMapper.findPostByProductId(id, TenantContext.getCurrentTenant());
    }

    public Post findPostById(Integer id) {
       return postMapper.findPostById(id, TenantContext.getCurrentTenant());
    }

    public Boolean update(Integer id, PostDto postDto) {

        Post post = postMSMapper.PostDtoToPost(postDto);
        post.setTenantId(TenantContext.getCurrentTenant());
        postMapper.updatePost(id, post);

        return true;
    }

    public PostDto save(PostDto postDto) {

        Post post = postMSMapper.PostDtoToPost(postDto);
        post.setTenantId(TenantContext.getCurrentTenant());

        postMapper.savePost(post);

        if (post != null && post.getId() > 0) {
            return postMSMapper.PostToPostDto(post);
        }

        throw new RuntimeException("Error saving Post to the Database");
    }
}
