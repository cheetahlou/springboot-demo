package com.cheelou.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @createTime 2019/5/13 15:40
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/halo")
    public JSONObject hi(){
        JSONObject res = new JSONObject();
        res.put("hello","world");
        logger.debug("打印HelloWorld语句,res={}",res);
        return res;
    }

    public static void main(String args[]) {

        //抛出异常被正确捕捉到 先执行catch中的打印语句, 后执行finally语句, 再执行剩下的
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("exception occurs and handled, finally block is always executed");
        }
        System.out.println("rest of the code...");

        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("exception occurs and not handled, finally block is always executed");
        }

        System.out.println("rest of the code...");

    }
}
