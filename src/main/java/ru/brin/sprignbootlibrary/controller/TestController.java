package ru.brin.sprignbootlibrary.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log
public class TestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        return "redirect:" + request.getRequestURL().append("index.xhtml").toString();
    }
}
