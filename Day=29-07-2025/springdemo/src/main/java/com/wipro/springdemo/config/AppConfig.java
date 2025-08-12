package com.wipro.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.wipro.springdemo.beans")
public class AppConfig {
}
