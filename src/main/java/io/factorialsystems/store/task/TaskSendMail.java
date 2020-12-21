package io.factorialsystems.store.task;

import io.factorialsystems.store.business.mail.AWSMailer;
import io.factorialsystems.store.business.mail.Mail;
import io.factorialsystems.store.domain.tenant.Tenant;
import io.factorialsystems.store.mapper.tenant.TenantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskSendMail implements Runnable {
    private String eMail;
    private String message;
    private String subject;
    private String tenantId;
    private final TenantMapper tenantMapper;
    private final ApplicationContext applicationContext;

    public void setParameters(String eMail, String subject, String message, String tenantId) {
        this.eMail = eMail;
        this.tenantId = tenantId;
        this.message = message;
        this.subject = subject;
    }

    @Override
    public void run() {

        Tenant tenant = tenantMapper.findById(tenantId);

        Mail m = new Mail(eMail);
        m.setFrom(tenant.getEmail());
        m.setSubject(subject);
        m.setBody(message);

        AWSMailer awsMailer = applicationContext.getBean(AWSMailer.class);

        try {
            awsMailer.sendMail(m);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
