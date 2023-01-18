package com.cloudofgoods.order;

import com.cloudofgoods.order.repository.DeliveryAreaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@RequiredArgsConstructor
@Slf4j
@ConfigurationPropertiesScan
@EnableR2dbcRepositories
public class ApplicationOrder {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationOrder.class, args);
    }
}