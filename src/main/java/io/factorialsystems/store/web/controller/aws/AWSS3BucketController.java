package io.factorialsystems.store.web.controller.aws;

import io.factorialsystems.store.service.aws.AmazonS3BucketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/aws")
public class AWSS3BucketController {
    private final AmazonS3BucketService amazonS3BucketService;

    @PostMapping("/uploadFile")
    @PreAuthorize("hasRole('ADMIN')")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonS3BucketService.uploadFile(file);
    }

    @PostMapping("/deleteFile")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteFile(@RequestBody String fileURL) {
        return this.amazonS3BucketService.deleteFileFromBucket(fileURL);
    }
}
