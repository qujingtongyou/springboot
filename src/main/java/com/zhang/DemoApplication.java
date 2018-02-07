package com.zhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *@Author xiaohei
 *@Date 2017/12/26 14:40
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = new Date();
		System.out.println(sdf.format(nowDate)+"start..................................1");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(sdf.format(nowDate)+"end..................................1");
	}
	
}
