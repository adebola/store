package io.factorialsystems.store.business.sms;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@Scope("prototype")
@NoArgsConstructor
public class SMSSender {

    @Value("${SMS_URL}")
    private String smsUrl;

    public void sendMessage(String message, String to) {
        RestTemplate restTemplate = new RestTemplate();

        String newTo = null;

        try {
            if (to.indexOf('0') == 0) {
                newTo = "234" + to.substring(1);
            } else if (to.indexOf("+") == 0) {
                newTo = to.substring(1);
            } else if (to.substring(0,3) == "234") {
                 newTo = to;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        if (newTo == null) {
            throw new RuntimeException(String.format("Unable to parse Telephone Number %s", to));
        } else {
            log.info(String.format("Sending Message to %s", newTo));
        }

        MultiValueMap param = new LinkedMultiValueMap<>();
        param.add("user", "adebola");
        param.add("pass", "uebaH4y2an5r@NT");
        param.add("from", "DELIFROST");
        param.add("to", newTo);
        param.add("msg", message);
        param.add("type", 0);

        String response = restTemplate.postForObject("https://sms.hollatags.com/api/send", param, String.class);

        log.info(String.format("SMS Response is %s", response));
    }
}
