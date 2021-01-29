package io.factorialsystems.store.service.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@AllArgsConstructor
public class UploadFile {
    private File file;
    private String fileName;
}
