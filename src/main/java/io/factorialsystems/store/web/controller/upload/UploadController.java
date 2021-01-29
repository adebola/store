package io.factorialsystems.store.web.controller.upload;

import io.factorialsystems.store.payload.response.MessageResponse;
import io.factorialsystems.store.service.file.FileService;
import io.factorialsystems.store.service.file.UploadFile;
import io.factorialsystems.store.service.update.UpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/upload")
public class UploadController {
    private final FileService fileService;
    private final UpdateService updateService;

    @PostMapping("/price")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> uploadFile(@RequestPart(value = "file") MultipartFile file) {

        try {
            UploadFile uploadFile = fileService.uploadFile(file);

            if (uploadFile == null) {
                return new ResponseEntity<>(new MessageResponse("Error Uploading File"), HttpStatus.BAD_REQUEST);
            }

            updateService.updatePrices(uploadFile);

            return new ResponseEntity<>(new MessageResponse("Prices have been updated successfully"), HttpStatus.OK);
        } catch (Exception ex) {
            log.info(String.format("Exception Thrown Message : %s", ex.getMessage()));
            return new ResponseEntity<>(new MessageResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
