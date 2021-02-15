package io.factorialsystems.store.reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.util.ResourceUtils;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstReport {

    public void runReport()  {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("studentName", "Adebola");

        Student student1 = new Student(1L, "Adebola", "Omoboya", "Valerian", "Lagos");
        Student student2 = new Student(2L, "Foluke", "Omoboya", "25 Valerian", "Lagos");

        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);

        try {
            File file = ResourceUtils.getFile("classpath:jasper/FirstReport.jrxml");
            InputStream in = new FileInputStream(file);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);
            JasperReport report = JasperCompileManager.compileReport(in);

            JRBaseTextField textField = (JRBaseTextField) report.getTitle().getElementByKey("name");
            textField.setForecolor(Color.GREEN);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

            JasperExportManager.exportReportToPdfFile(print, "./file.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
