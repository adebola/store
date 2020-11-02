package io.factorialsystems.store.task;

import io.factorialsystems.store.business.mail.AWSMailer;
import io.factorialsystems.store.business.mail.Mail;
import io.factorialsystems.store.business.report.InvoicePDF;
import io.factorialsystems.store.domain.tenant.Tenant;
import io.factorialsystems.store.mapper.tenant.TenantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskPDFMail implements Runnable {
    private Mail mail;
    private Integer orderId;
    private String tenantId;

    private final ApplicationContext applicationContext;
    private final TenantMapper tenantMapper;

    public void setParameters(Mail mail, String tenantId, Integer orderId) {
        this.orderId = orderId;
        this.mail = mail;
        this.tenantId = tenantId;
    }

    @Override
    public void run() {

        if (mail == null) {
            throw new RuntimeException("No Mail to Send in Class TaskPDFMail");
        }

        // Get Tenant Details From Database
        Tenant tenant = tenantMapper.findById(tenantId);

        mail.setFrom(tenant.getEmail());
        mail.setSubject(String.format("Your Order from %s OrderId %d", tenant.getOrganization(), orderId));
        mail.setBody(String.format("Please find attached from us at %s your Invoice with Thanks", tenant.getOrganization()));

        // Generate PDF
        mail.setFileName(new InvoicePDF().generateInvoice());
        AWSMailer awsMailer = applicationContext.getBean(AWSMailer.class);

        try {
            awsMailer.sendMail(mail);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
