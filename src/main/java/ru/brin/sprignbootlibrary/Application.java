package ru.brin.sprignbootlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        FacesServlet servlet = new FacesServlet();
//        return new ServletRegistrationBean(servlet, "*.xhtml");
//    }

}
