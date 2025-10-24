package com.polimet.museo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolimetApplication {
    public static void main(String[] args) {
        SpringApplication.run(PolimetApplication.class, args);
        System.out.println("PoliMet API se ha iniciado.");
    }
}
