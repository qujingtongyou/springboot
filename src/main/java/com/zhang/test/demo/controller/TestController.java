package com.zhang.test.demo.controller;

import com.zhang.test.demo.entity.Author;
import com.zhang.test.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @GetMapping("testcon")
    public List<Author> testcon(){
       List<Author> data = authorService.queryAllAuthor();
        for (Author a:data) {
            System.out.print(a.getAuthorName());
        }
        return authorService.queryAllAuthor();
    }
}
