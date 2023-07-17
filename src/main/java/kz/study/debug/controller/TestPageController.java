package kz.study.debug.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TestPageController {

    @GetMapping(value = "/test-page")
    public String testPage(){
        return "test-page";
    }
}
