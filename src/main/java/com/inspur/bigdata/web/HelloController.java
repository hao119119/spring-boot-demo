package com.inspur.bigdata.web;

import com.inspur.bigdata.web.exhandler.MyException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nobody on 2016/9/5.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/my_error")
    public String myError() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/my_json_error")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    // http://localhost:8080/hello_world?name=chenhao
    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }






}
