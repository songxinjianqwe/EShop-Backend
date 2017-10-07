package cn.sinjinsong.eshop.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableConfigurationProperties
@EnableWebMvc
@ComponentScan({"cn.sinjinsong"})
public class EShopApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EShopApplication.class, args);
    }
}
