package io.factorialsystems.store.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PasswordResetRequest {
    private Integer id;
    private String uuid;
    private Integer userId;

    public PasswordResetRequest(Integer userId, UUID uuid) {
        this.userId = userId;
        this.uuid = uuid.toString();
    }
}
