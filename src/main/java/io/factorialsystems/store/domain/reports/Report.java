package io.factorialsystems.store.domain.reports;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private Integer id;
    private String reportName;
    private String reportFile;
    private String reportNarrative;
}
