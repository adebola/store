package io.factorialsystems.store.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Context {
    private String currentTenant;
    private String currentUser;
}
