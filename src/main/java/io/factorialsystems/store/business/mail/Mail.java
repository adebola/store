package io.factorialsystems.store.business.mail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {

    String to;
    String from;
    String subject;
    String body;

    String fileName;

    public Mail(String to) {
        this.to = to;
    }
}
