package io.factorialsystems.store.web.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    @Null
    private Integer id;

    @NotNull
    private Integer user_id;

    @NotNull
    @NotBlank
    private String address;

    private Boolean is_default;
}
