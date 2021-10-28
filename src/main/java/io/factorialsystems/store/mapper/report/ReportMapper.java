package io.factorialsystems.store.mapper.report;

import io.factorialsystems.store.domain.reports.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReportMapper {
    @Select("select id, report_name, report_file, report_narrative from reports")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "reportName", column = "report_name"),
            @Result(property = "reportFile", column = "report_file"),
            @Result(property = "reportNarrative", column = "report_narrative")
    })
    List<Report> findAll();

    @Select("select id, report_name, report_file, report_narrative from reports where report_name like CONCAT(#{search}, '%')")
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "report_name", column = "reportName"),
            @Result(property = "report_file", column = "reportFile"),
            @Result(property = "report_narrative", column = "reportNarrative")
    })
    List<Report> search(String search);
}
