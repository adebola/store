package io.factorialsystems.store.domain.image;

import lombok.Data;

@Data
public class Image {
    private Integer id;
    private String imagePath;

    public Image(String imagePath) {
        this.imagePath = imagePath;
    }
}
