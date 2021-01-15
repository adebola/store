package io.factorialsystems.store.task;

import io.factorialsystems.store.business.mail.AWSMailer;
import io.factorialsystems.store.business.mail.Mail;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskSendAdminRegistrationEmail implements Runnable {
    private String email;
    private String tenantId;
    private final ApplicationContext applicationContext;


    @Override
    public void run() {
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<User> users = userMapper.getAllAdmins(tenantId);

        users.forEach(user -> {
            log.info(String.format("ADMIN USER : %s", user.getEmail()));

            Mail mail = new Mail(user.getEmail());
            mail.setFrom("delifrost@factorialsystems.io");
            mail.setSubject("User Registration");
            mail.setBody(String.format("User %s has just registered on the platform and requires activation please visit https://delifrost-admin.web.app/admin/users/users to activate", email));

            AWSMailer awsMailer = applicationContext.getBean(AWSMailer.class);

            try {
                awsMailer.sendMail(mail);
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
        });
    }

    public void setParameter(String email, String tenantId) {
        this.email = email;
        this.tenantId = tenantId;
    }
}
