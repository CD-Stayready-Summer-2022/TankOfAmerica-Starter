package com.codedifferently.tankofamerica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TankOfAmericaApplication {
    private static Logger logger = LoggerFactory.getLogger(TankOfAmericaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TankOfAmericaApplication.class, args);
    }


}
