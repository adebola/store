package io.factorialsystems.store.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FulFillOrder {
    Integer id;
    Date fulfill_date;
}
