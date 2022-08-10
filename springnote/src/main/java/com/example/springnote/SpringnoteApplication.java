package com.example.springnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ServletComponentScan
public class SpringnoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringnoteApplication.class, args);
    }

}
