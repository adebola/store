package io.factorialsystems.store.service.update;

import io.factorialsystems.store.mapper.product.ProductSKUMapper;
import io.factorialsystems.store.security.TenantContext;
import io.factorialsystems.store.service.file.UploadFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateService {
    private final ProductSKUMapper productSKUMapper;

    public void updatePrices(UploadFile uploadFile) {

        String row;
        BufferedReader csvReader = null;

        try {
            csvReader = new BufferedReader(new FileReader(uploadFile.getFile()));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");

                String sku = data[0];
                double price = Double.parseDouble(data[1]);
                double discount;

                if (data.length == 3) {
                    discount = Double.parseDouble(data[2]);
                } else {
                    discount = 0.0;
                }

                log.info(String.format("SKU: %s, price: %f, discount: %f", sku, price, discount));

                productSKUMapper.updatePrice(sku, price, discount, TenantContext.getCurrentTenant());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            uploadFile.getFile().delete();

            try {
                if (csvReader != null) {
                    csvReader.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
