package com.sbw.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sbw on 2017/11/30.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    String hello() {
        return "Hello World!";
    }

}
