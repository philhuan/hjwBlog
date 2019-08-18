package com.hjwblog.hjwblogserver.config;


import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
class DruidConfiguration  {

    private Logger logger = LoggerFactory.getLogger(this.getClass());  //log4j日志
    /**
     * Druid 的DataResource配置类
     */

    public class DruidDataSourceConfig {


        @Value("${spring.datasource.url}")
        private String dbUrl;

        @Value("${spring.datasource.username}")
        private String username;

        @Value("${spring.datasource.password}")
        private String password;

        @Value("${spring.datasource.driver-class-name}")
        private String driverClassName;

        @Value("${spring.datasource.druid.initialSize}")
        private int initialSize;

        @Value("${spring.datasource.druid.minIdle}")
        private int minIdle;

        @Value("${spring.datasource.druid.maxActive}")
        private int maxActive;

        @Value("${spring.datasource.druid.maxWait}")
        private int maxWait;

        @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
        private int timeBetweenEvictionRunsMillis;

        @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
        private int minEvictableIdleTimeMillis;

        @Value("${spring.datasource.druid.validationQuery}")
        private String validationQuery;

        @Value("${spring.datasource.druid.testWhileIdle}")
        private boolean testWhileIdle;

        @Value("${spring.datasource.druid.testOnBorrow}")
        private boolean testOnBorrow;

        @Value("${spring.datasource.druid.testOnReturn}")
        private boolean testOnReturn;

        @Value("${spring.datasource.druid.poolPreparedStatements}")
        private boolean poolPreparedStatements;

        @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
        private int maxPoolPreparedStatementPerConnectionSize;

        @Value("${spring.datasource.druid.filters}")
        private String filters;




        @Bean
        @Primary
        public DataSource dataSource() {
            DruidDataSource datasource = new DruidDataSource();

            datasource.setUrl(this.dbUrl);
            datasource.setUsername(username);
            datasource.setPassword(password);
            datasource.setDriverClassName(driverClassName);

            //configuration
            datasource.setInitialSize(initialSize);
            datasource.setMinIdle(minIdle);
            datasource.setMaxActive(maxActive);
            datasource.setMaxWait(maxWait);
            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            datasource.setValidationQuery(validationQuery);
            datasource.setTestWhileIdle(testWhileIdle);
            datasource.setTestOnBorrow(testOnBorrow);
            datasource.setTestOnReturn(testOnReturn);
            datasource.setPoolPreparedStatements(poolPreparedStatements);
            datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
            try {
                datasource.setFilters(filters);
            } catch (SQLException e) {
                logger.error("druid configuration initialization filter", e);
            }


            return datasource;
        }
    }

}



