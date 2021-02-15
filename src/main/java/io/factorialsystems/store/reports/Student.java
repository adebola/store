package io.factorialsystems.store.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
}
