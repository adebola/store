package io.factorialsystems.store.mapper.blog;

import io.factorialsystems.store.domain.blog.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PostMapper {

    String SelectPostByProduct = "select p.id,\n" +
            "            p.title,\n" +
            "            p.content,\n" +
            "            p.product_id,\n" +
            "            p.likes,\n" +
            "            p.dislikes,\n" +
            "            u.id as userId,\n" +
            "            u.fullname,\n" +
            "            u.email,\n" +
            "            p.createdAt\n" +
            "from\n" +
            "            posts p, users u\n" +
            "where\n" +
            "            p.tenant_id = #{tenantId} and\n" +
            "            p.product_id = #{id} and\n" +
            "            p.user_id = u.id";

    String SelectPostById = "select p.id,\n" +
            "            p.title,\n" +
            "            p.content,\n" +
            "            p.product_id,\n" +
            "            p.likes,\n" +
            "            p.dislikes,\n" +
            "            u.id as userId,\n" +
            "            u.fullname,\n" +
            "            u.email,\n" +
            "            p.createdAt,\n" +
            "from\n" +
            "            posts p, users u\n" +
            "where\n" +
            "            p.tenant_id = #{tenantId} and\n" +
            "            p.id = #{id} and\n" +
            "            p.user_id = u.id";


    @Select(SelectPostByProduct)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "product_id", column = "product_id"),
            @Result(property = "likes", column = "likes"),
            @Result(property = "dislikes", column = "dislikes"),
            @Result(property = "creator_id", column = "userId"),
            @Result(property = "creator_name", column = "fullname"),
            @Result(property = "creator_email", column = "email"),
            @Result(property = "createdAt", column = "createdAt"),
            @Result(property = "comment_count", column = "id", javaType = Integer.class, one=@One(select="getCommentCount")),
    })
    List<Post> findPostByProductId(Integer id, String tenantId);


    @Select(SelectPostById)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "product_id", column = "product_id"),
            @Result(property = "likes", column = "likes"),
            @Result(property = "dislikes", column = "dislikes"),
            @Result(property = "creator_id", column = "userId"),
            @Result(property = "creator_name", column = "fullname"),
            @Result(property = "creator_email", column = "email"),
            @Result(property = "createdAt", column = "createdAt")
    })
    Post findPostById(Integer id, String tenantId);


    @Update("update posts set title = #{post.title}, content = #{post.content}, likes = #{post.likes}, dislikes = #{post.dislikes}, lastModifiedAt = NOW() where id = #{id} and tenant_id = #{post.tenantId}")
    public Integer updatePost(Integer id, Post post);

    @Insert("insert into posts(title, content, user_id, product_id, tenant_id) values(#{title}, #{content}, #{creator_id}, #{product_id}, #{tenantId})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Integer.class)
    public Integer savePost(Post post);

    @Select("select count(*) as count from comments where post_id = #{id}")
    Integer getCommentCount(Integer id);
}
