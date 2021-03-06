package io.factorialsystems.store.payload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class PasswordChangeRequest {

    @NotNull
    @NotBlank
    private String currentpassword;

    @NotNull
    @NotBlank
    private String newPassword;
}
