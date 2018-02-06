package com.zhang.test.demo.controller;

import com.zhang.common.util.PropertiesUtil;
import com.zhang.test.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 15939 on 2017/12/21.
 *
 * @author xiaohei
 * @date 2017/12/21 14:01
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    AuthorService authorService;

    @ModelAttribute
    public Model get(Model index) {
        Model model = PropertiesUtil.getMediaStatic(index);
        return model;
    }

    @GetMapping("loginUser")
    @ResponseBody
    public String loginUser(){
        try {
            return "123456789";
        }catch (Exception e){
            return "123456789";
        }
    }
    @GetMapping("queryAuthor")
    @ResponseBody
    public Map<String,Object> queryAuthor(){
        Map<String,Object> dataMap = new HashMap<>(16);
        dataMap.put("authorList",authorService.queryAllAuthor());
        return dataMap;
    }
    @GetMapping("toTestThmeleaf")
    public String toTestThmeleaf(){
        return "testThmeleaf";
    }

    @GetMapping("index")
    public String index(){
        return "redirect:/templates/thymeleaf/index.html";
    }

    @GetMapping("testPage")
    public String testPage(){
        return "testPage";
    }
}
