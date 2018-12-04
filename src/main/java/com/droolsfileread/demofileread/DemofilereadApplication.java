package com.droolsfileread.demofileread;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemofilereadApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemofilereadApplication.class, args);
    }
        @Bean
        public KieContainer kieContainer(){
            return KieServices.Factory.get().getKieClasspathContainer();
        }

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(DemofilereadApplication.class);
        }


}
