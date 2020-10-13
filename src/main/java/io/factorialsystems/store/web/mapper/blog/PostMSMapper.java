package io.factorialsystems.store.web.mapper.blog;


import io.factorialsystems.store.domain.blog.Post;
import io.factorialsystems.store.web.mapper.util.DateMSMapper;
import io.factorialsystems.store.web.model.blog.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {DateMSMapper.class})
public interface PostMSMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "content", target = "content"),
            @Mapping(source = "product_id", target = "product_id"),
            @Mapping(source = "likes", target = "likes"),
            @Mapping(source = "dislikes", target = "dislikes"),
            @Mapping(source = "creator_id", target = "creator_id"),
            @Mapping(source = "creator_name", target = "creator_name"),
            @Mapping(source = "creator_email", target = "creator_email"),
            @Mapping(source = "createdAt", target = "createdDate"),
            @Mapping(source = "comment_count", target = "comment_count"),
    })
    PostDto PostToPostDto(Post post);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "content", target = "content"),
            @Mapping(source = "product_id", target = "product_id"),
            @Mapping(source = "likes", target = "likes"),
            @Mapping(source = "dislikes", target = "dislikes"),
            @Mapping(source = "creator_id", target = "creator_id"),
            @Mapping(source = "creator_name", target = "creator_name"),
            @Mapping(source = "creator_email", target = "creator_email"),
            @Mapping(source = "createdDate", target = "createdAt"),
            @Mapping(source = "comment_count", target = "comment_count"),
    })
    Post PostDtoToPost(PostDto postDto);

    List<PostDto> ListPostToPostDto(List<Post> post);
    List<Post> ListPostDtoToPost(List<PostDto> postDto);


}
