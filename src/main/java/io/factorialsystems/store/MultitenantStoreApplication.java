package io.factorialsystems.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.*;

@SpringBootApplication (exclude = {
        ContextCredentialsAutoConfiguration.class,
        ContextInstanceDataAutoConfiguration.class,
        ContextRegionProviderAutoConfiguration.class,
        ContextResourceLoaderAutoConfiguration.class,
        ContextStackAutoConfiguration.class,
        MailSenderAutoConfiguration.class,
})
public class MultitenantStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultitenantStoreApplication.class, args);
    }

}
