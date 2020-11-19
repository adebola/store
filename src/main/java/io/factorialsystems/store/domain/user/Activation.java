package io.factorialsystems.store.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Activation {
    private String id;
    private Integer user_id;
    private Date createdAt;
    private Date closedAt;
}
