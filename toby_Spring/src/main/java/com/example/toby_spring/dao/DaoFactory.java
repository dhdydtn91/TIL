package com.example.toby_spring.dao;

import com.example.toby_spring.service.UserService;
import com.example.toby_spring.util.DummyMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Controller
@Repository
@Configuration
public class DaoFactory {

    @Bean
    public UserDaoJdbc userDao() throws ClassNotFoundException {
        return new UserDaoJdbc(dataSource());
    }

    @Bean
    public JdbcContext jdbcContext() throws ClassNotFoundException {
        return new JdbcContext(dataSource());
    }

    @Bean
    public UserService userService() throws ClassNotFoundException {
        UserService userService = new UserService(userDao());
        userService.setTransactionManager(transactionManager());
        userService.setMailSender(mailSender());
        return userService;
    }

    @Bean
    public DummyMailSender mailSender() {
        DummyMailSender javaMailSender = new DummyMailSender();
        //javaMailSender.setHost("mail.server.com");
        return javaMailSender;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws ClassNotFoundException {
        return new DataSourceTransactionManager(dataSource());
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
