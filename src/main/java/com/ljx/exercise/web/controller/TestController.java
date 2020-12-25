package com.ljx.exercise.web.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 13:51 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/api/message")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","你好!这是TestController响应的内容!!!!");
        return modelAndView;
    }

}
