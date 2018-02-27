package com.zhang.test.demo.controller;

import com.zhang.common.util.PropertiesUtil;
import com.zhang.test.demo.entity.Author;
import com.zhang.test.demo.service.AuthorService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @PostMapping("userLogin")
    public String userLogin(String userName, String userPassword, Model model, HttpSession session, Author author){
        if(userName.equals("15939477300")){
            String password = Md5Hash.fromBase64String(userPassword).toString();
            if(password.equals("d76df80000")){
                session.setAttribute("userToken",userName);
                return "testThmeleaf";
            }
            session.setAttribute("errorMassage","密码错误!");
            return "redirect:testPage";
        }
        session.setAttribute("errorMassage","账号不存在！");
        return "redirect:testPage";
    }
    @GetMapping("removeErrorMassage")
    public void removeErrorMassage(HttpSession session){
        session.removeAttribute("errorMassage");
    }

    @GetMapping("toTestNavigation")
    public String toTestNavigation(){
        return "testNavigation";
    }

    @GetMapping("toTestWebSocket")
    public String toTestWebSocket(){
        return "testWebSocket";
    }
}