package io.factorialsystems.store.service.auth;

import io.factorialsystems.store.security.RecaptchaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CaptchaService {
    @Value("${CAPTCHA_SECRET}")
    private String recaptchaSecret;

    @Value("${CAPTCHA_URL}")
    private String recaptchaVerifyUrl;

    public Boolean verify(String response) {
        MultiValueMap param = new LinkedMultiValueMap<>();
        param.add("secret", recaptchaSecret);
        param.add("response", response);

        try {
            RestTemplate restTemplate = new RestTemplate();
            RecaptchaResponse recaptchaResponse  = restTemplate.postForObject(recaptchaVerifyUrl, param, RecaptchaResponse.class);
            return recaptchaResponse.isSuccess();
        } catch (RestClientException rest) {
            throw new RuntimeException(String.format("Unable to authenticate with Google EndPoint, message: %s", rest.getMessage()));
        }
    }
}
