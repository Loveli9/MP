package com.hyp.task.quartz;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * 数据原配置
 * */
@Configuration
public class DataSourceConfig
{
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

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

    @Value("${spring.datasource.druid.connectionProperties}")
    private String properties;

    @Bean
    public DataSource dataSource()
    {
        DruidDataSource configDataSource = new DruidDataSource();
        configDataSource.setUrl(url);
        configDataSource.setDriverClassName(driverClassName);
        configDataSource.setUsername(userName);
        configDataSource.setPassword(password);
        configDataSource.setInitialSize(initialSize);
        configDataSource.setDefaultAutoCommit(true);
        configDataSource.setMinIdle(minIdle);
        configDataSource.setMaxActive(maxActive);
        configDataSource.setMaxWait(maxWait);
        configDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        configDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        configDataSource.setValidationQuery(validationQuery);
        configDataSource.setTestWhileIdle(testWhileIdle);
        configDataSource.setTestOnBorrow(testOnBorrow);
        configDataSource.setTestOnReturn(testOnReturn);
        configDataSource.setConnectionProperties(properties);
        return configDataSource;
    }
}
