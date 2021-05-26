package com.example.toby_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Controller
@Repository
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() throws ClassNotFoundException {
        return new UserDao(dataSource());
    }

    @Bean
    public JdbcContext jdbcContext() throws ClassNotFoundException {
        return new JdbcContext(dataSource());
    }

    @Bean      // ----------> <bean
    public DataSource dataSource() throws ClassNotFoundException {  // ------> id="connectionMaker"
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
        dataSource.setDriverClass(driverClass);
        dataSource.setUrl("jdbc:mysql://localhost:3306/springbook?serverTimezone=Asia/Seoul");
        dataSource.setSchema("springbook");
        dataSource.setUsername("cos");
        dataSource.setPassword("cos1234");

        return dataSource;
    }

}
