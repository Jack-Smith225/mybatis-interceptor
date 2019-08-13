package yuwei35kd.mybatis.interceptor.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource getHikariDataSource() {
        //按照目标数据源名称和目标数据源对象的映射存放在Map中
        HikariDataSource dataSource = new HikariDataSource();
        return dataSource;
    }
}
