package io.factorialsystems.store.payload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
public class PasswordRequest {
    @NotBlank
    String password;
}
