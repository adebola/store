package io.factorialsystems.store.business.mail;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.charset.StandardCharsets;

@Slf4j
@Setter
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class AWSMailer  {
    private final JavaMailSender mailSender;

    public void sendMail(Mail mail) throws MessagingException {

        if (mail != null) {
            MimeMessage message = getMimeMessage(mail);
            mailSender.send(message);

            log.info(String.format("Mail sent to %s", mail.getTo()));
        }
    }

    private MimeMessage getMimeMessage(Mail mail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper =
                new MimeMessageHelper(
                        message,
                        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                        StandardCharsets.UTF_8.name());

        helper.setTo(mail.getTo());
        helper.setText(mail.getBody(), false);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());

        if (mail.getFileName() != null) {
            FileSystemResource file = new FileSystemResource(new File(mail.getFileName()));

            if (file.exists() && file.isReadable()) {
                helper.addAttachment(extractFilename(mail.getFileName()), file);
            }
        }

        return message;
    }

    private String extractFilename(String path) {
        String result = path.substring(path.lastIndexOf('/') + 1);
        return result.substring(result.lastIndexOf('\\') + 1);
    }
}
