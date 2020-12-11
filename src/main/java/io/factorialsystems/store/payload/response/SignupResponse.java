package io.factorialsystems.store.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SignupResponse {
    private Integer status;
    private String message;
}
