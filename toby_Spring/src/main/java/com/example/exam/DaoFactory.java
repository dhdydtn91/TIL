package com.example.exam;

import org.apache.naming.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//3자 팩토리 클래스
//IOC DI
// 빈팩토리 또는 어플리케이션 컨텍스트  //IOC 컨테이너
@ComponentScan
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    @Bean
    public SimpleConnectionMaker connectionMaker() {
        return new MysqlConnectionMaker();
    }

}
