package com.errorist1540.autoconfiguration.server.configuration;

import com.errorist1540.autoConfiguration.repo.TestMethod;
import com.errorist1540.autoConfiguration.repo.TestProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class CommonConfiguration {

    private final TestProperties testProperties;
    private final ApplicationContext applicationContext;
    private final TestMethod testMethod;


    @Bean
    public CommandLineRunner getRunner() {
        //라이브러리로 만든 메소드 실행 (application.yaml에 넣은 값이 잘 나오는지 확인)
        testMethod.getProperties();

        //key값 1개 불러오기
        log.info("get key1 value: {}", testProperties.getKey1());

        //bean 확인
        if (applicationContext != null) {
            String[] beans = applicationContext.getBeanDefinitionNames();

            for (String bean : beans) {
                System.out.println("bean : " + bean);
            }
        }
        return null;
    }
}