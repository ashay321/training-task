package com.fareye.training.controller;

import java.util.*;
import java.io.FileReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    Properties properties;

    PropertyController() {
        properties = new Properties();

        try {
            FileReader reader = new FileReader("/home/ashay/Downloads/training/src/main/resources/application.properties");
            properties.load(reader);
        } catch (Exception e) {
            System.out.println("Error occurred while reading app-properties");
        }
    }

    @GetMapping("/application-properties")
    public Properties getProperties() {
        return properties;
    }

}