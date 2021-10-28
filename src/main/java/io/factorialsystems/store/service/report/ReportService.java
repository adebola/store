package io.factorialsystems.store.service.report;

import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.reports.Report;
import io.factorialsystems.store.mapper.order.OrderMapper;
import io.factorialsystems.store.mapper.report.ReportMapper;
import io.factorialsystems.store.security.TenantContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportService {
    private final OrderMapper orderMapper;
    private final ReportMapper reportMapper;

    public List<Report> findReports() {
        return reportMapper.findAll();
    }

    public List<Report> searchReports(String searchString) {
        return reportMapper.search(searchString);
    }

    public ByteArrayInputStream runReport(String reportName) {

        List<Order> orders = orderMapper.findAll(TenantContext.getCurrentTenant());

        try {
            InputStream in = new FileInputStream(ResourceUtils.getFile("classpath:jasper/order.jrxml"));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("reportHeader", "All Order Report");
            parameters.put("tableData", dataSource);

            JasperReport report = JasperCompileManager.compileReport(in);

            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(print, bos);

            bos.flush();
            bos.close();

            return new ByteArrayInputStream(bos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
