package com.sv.ts;

import com.sv.ts.config.advice.SvMessageSource;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TimesheetApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(TimesheetApplication.class, args);
    }

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        SvMessageSource messageSource = new SvMessageSource("default", 60, "classpath:i18n/messages","classpath:i18n/messages-legacy");
        return messageSource;
    }

}
