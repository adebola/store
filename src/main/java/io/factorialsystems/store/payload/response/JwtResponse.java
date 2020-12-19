package io.factorialsystems.store.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JwtResponse {
    private Integer status;
    private String message;
    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private String telephone;
    private String address;
    private String organization;
    private String token;
}
