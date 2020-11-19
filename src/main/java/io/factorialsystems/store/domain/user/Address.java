package io.factorialsystems.store.domain.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    Integer id;
    Integer user_id;
    String address;
    Boolean is_default;
}
