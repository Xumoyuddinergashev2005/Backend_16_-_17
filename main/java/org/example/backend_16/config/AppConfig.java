package org.example.backend_16.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.example.backend_16.config")
@EnableWebMvc
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public JdbcTemplate provideJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);

    }
}
