package io.factorialsystems.store.web.model.blog;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    @Null
    Integer id;

    @NotBlank
    String title;

    @NotBlank
    String content;

    Integer product_id;

    Integer likes;

    Integer dislikes;

    Integer creator_id;

    @Null
    String creator_name;

    @Null
    String creator_email;

    @Null
    Integer comment_count;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;
}
