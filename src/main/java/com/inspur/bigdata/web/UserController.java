package com.inspur.bigdata.web;

import com.inspur.bigdata.domain.Customer;
import com.inspur.bigdata.domain.CustomerRepository;
import com.inspur.bigdata.domain.User;
import com.inspur.bigdata.domain.p.UserRepository;
import com.inspur.bigdata.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by nobody on 2016/9/5.
 */

@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);
    // 创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @Autowired
    UserService userService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    @ApiOperation(value="获取用户列表", notes="")
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        log.info("get user list");
        if(log.isDebugEnabled())
            log.info("this is a debug info");
        return userService.getAllUsers();
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之u外，还可以通过@RequestParam从页面中传递参数
        userService.create(user);
        return "success";
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        userService.create(user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return userService.getUserById(id);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的name来获取用户详细信息")
    @RequestMapping(value="/name/{name}", method=RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @ApiOperation(value="删除用户详细信息", notes="根据url的name来删除用户")
    @RequestMapping(value="/name/{name}", method=RequestMethod.DELETE)
    public String deleteUserByName(@PathVariable String name) {
        userService.deleteByName(name);
        return "success";
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        userService.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
        List<User> userList = userService.getAllUsers();
        for (User userIn : userList){
            if(userIn.getId()==user.getId() && userIn.getName().equals(user.getName()))
                return "login success";
        }
        return "login failed";
    }

}
