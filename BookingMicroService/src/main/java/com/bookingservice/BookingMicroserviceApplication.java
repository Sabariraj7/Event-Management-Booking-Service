package com.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan({"com.bookingservice.entity", "com.eventmanagement.Entity"})
public class BookingMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingMicroserviceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
