package io.factorialsystems.store.domain.tenant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tenant {
    private String id;
    private String organization;
    private String email;
}
