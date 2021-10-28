package io.factorialsystems.store.web.controller.report;

import io.factorialsystems.store.domain.reports.Report;
import io.factorialsystems.store.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReportController {

    private final ReportService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Report>> getReports() {
        return new ResponseEntity<>(service.findReports(), HttpStatus.OK);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Report>> searchReports(@RequestParam(value = "searchString", required = false) String searchString) {
        return new ResponseEntity<>(service.searchReports(searchString), HttpStatus.OK);
    }

    @GetMapping("/report/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InputStreamResource> runReport(@PathVariable("name") String name) {
        ByteArrayInputStream byteArrayInputStream = service.runReport(name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}
