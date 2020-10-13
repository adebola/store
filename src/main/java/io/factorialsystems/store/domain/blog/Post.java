package io.factorialsystems.store.domain.blog;


import lombok.Data;

import java.util.Date;

@Data
public class Post {
    Integer id;
    String title;
    String content;
    Integer product_id;
    Integer likes;
    Integer dislikes;
    Integer creator_id;
    String creator_name;
    String creator_email;
    Date createdAt;
    Integer comment_count;
    String TenantId;
}
