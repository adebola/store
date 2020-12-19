package io.factorialsystems.store.payload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@ToString
@Getter
@Setter
public class SignupRequest {
    @NotBlank
    private String username;

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    @NotBlank
    private String fullName;

    private String telephone;
    private String address;

    @NotBlank
    @Size(min = 2, max = 40)
    private String password;

    String organization;

    @NotBlank
    private String captchaResponse;

    private Set<String> role;
}
