package com.imooc.spark;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * test
 */
@RestController
public class HelloBoot {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World Spring Boot......";
    }

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public ModelAndView firstDemo() {
        return new ModelAndView("test");
    }

    @RequestMapping(value = "/course_click_stat", method = RequestMethod.GET)
    public ModelAndView courseClickStat() {
        return new ModelAndView("pie");
    }
}
