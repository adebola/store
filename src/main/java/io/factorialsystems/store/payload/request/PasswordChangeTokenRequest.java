package io.factorialsystems.store.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PasswordChangeTokenRequest {

    @NotNull
    @NotBlank
    private String token;

    @NotNull
    @NotBlank
    private String password;
}
