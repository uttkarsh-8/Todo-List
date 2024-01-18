package com.uttkarsh.springboot.webApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("test-jpa")
    @ResponseBody
    public String sayHello() {
        return "SUIII";
    }

    // to return a jsp file, we need the whole file location like:
    // src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // So to get rid of this we will add some prefix for the path(not the file name)
    // & a suffix for the file extension which is .jsp
    @RequestMapping("testing")
    public String sayHelloJSP() {
        return "sayHello";
    }
}
