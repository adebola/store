/*+----------------------------------------------------------------------
 ||
 ||  Class MyBatisConfiguration
 ||
 ||         Author:  Adebola Omoboya
 ||
 ||        Purpose:  SpringBoot Java Configuration Class for MyBatis
 ||
 ||  Inherits From:  None
 ||
 ||     Interfaces:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  None
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  dataSource
 ||
 ++-----------------------------------------------------------------------*/

package io.factorialsystems.store.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class MyBatisConfiguration {

    @Bean
    public DataSource dataSource() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/fotojugdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "adebola";
        String password = "password";

        log.info("Datasource created successfully");

        PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);

        return dataSource;
    }
}
