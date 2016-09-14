package configs;

import dao.ContactDAO;
import dao.JdbcContactDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseConfig {

    @Resource
    Environment env;

    @Bean
    public DataSource getDataSource () {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
        ds.setUsername(env.getRequiredProperty("jdbc.username"));
        ds.setPassword(env.getRequiredProperty("jdbc.password"));
        ds.setUrl(env.getRequiredProperty("jdbc.url"));

        return ds;
    }

    @Bean
    public ContactDAO getJdbcDAO () {
        return new JdbcContactDAO(getDataSource());
    }

}
