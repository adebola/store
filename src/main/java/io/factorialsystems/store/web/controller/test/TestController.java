package io.factorialsystems.store.web.controller.test;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.reports.FirstReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping({"","/"})
    public ResponseEntity<MessageResponse> TestReport() {
        FirstReport firstReport = new FirstReport();
        firstReport.runReport();

        return new ResponseEntity<>(new MessageResponse("OK"), HttpStatus.OK);
    }
}
