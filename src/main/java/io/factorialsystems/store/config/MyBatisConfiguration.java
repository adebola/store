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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class MyBatisConfiguration {

    @Value("${DATABASE_URL}")
    private String url;

    @Value("${DATABASE_USER}")
    private String username;

    @Value("${DATABASE_PASSWORD}")
    private String password;

    @Value("${DATABASE_DRIVER}")
    private String driver;

    @Bean
    public DataSource dataSource() {
        log.info(String.format("Driver: %s, url: %s", driver, url));
        PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
        log.info("Datasource created successfully");
        return dataSource;
    }
}
