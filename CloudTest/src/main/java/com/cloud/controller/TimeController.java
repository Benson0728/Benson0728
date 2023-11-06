package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("/time")
@RefreshScope
public class TimeController {

    @Value("${benson.test}")
    private String data;
    @Value("${pattern.dateformat}")
    private String dateFormat;

    @GetMapping("/now")
    public String time(){
       return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateFormat));
    }
}
