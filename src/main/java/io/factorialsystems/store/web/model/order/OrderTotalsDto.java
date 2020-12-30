package io.factorialsystems.store.web.model.order;

import lombok.Data;

@Data
public class OrderTotalsDto {
    public String name;
    public String imagepath;
    public Double totals;
}
