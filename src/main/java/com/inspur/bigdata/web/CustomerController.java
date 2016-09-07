package com.inspur.bigdata.web;

import com.inspur.bigdata.domain.Customer;
import com.inspur.bigdata.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nobody on 2016/9/5.
 */

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    @ApiOperation(value="获取客户列表", notes="")
    public List<Customer> getCustomerList() {
        // 处理"/customer/"的GET请求，用来获取客户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        log.info("get user list");
        if(log.isDebugEnabled())
            log.info("this is a debug info");
        return customerService.getAllCustomers();
    }

    @ApiOperation(value="创建客户", notes="根据Customer对象创建客户")
    @ApiImplicitParam(name = "customer", value = "客户详细实体Customer", required = true, dataType = "Customer")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addCustomer(@ModelAttribute Customer customer) {
        // 处理"/customer/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之u外，还可以通过@RequestParam从页面中传递参数
        customerService.createCustomer(customer);
        return "success";
    }

    @ApiOperation(value="创建客户", notes="根据Customer对象创建客户")
    @ApiImplicitParam(name = "customer", value = "客户详细实体customer", required = true, dataType = "Customer")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postCustomer(@RequestBody Customer customer) {
        // 处理"/customer/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        customerService.createCustomer(customer);
        return "success";
    }

    @ApiOperation(value="获取客户详细信息", notes="根据url的id来获取客户详细信息")
    @ApiImplicitParam(name = "id", value = "客户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        // 处理"/customer/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return customerService.findCustomer(id);
    }

    @ApiOperation(value="获取客户详细信息", notes="根据url的name来获取客户详细信息")
    @RequestMapping(value="/name/{name}", method=RequestMethod.GET)
    public List<Customer> getCustomerByName(@PathVariable String name) {
        return customerService.findByLastName(name);
    }

    @ApiOperation(value="删除客户详细信息", notes="根据url的name来删除客户")
    @RequestMapping(value="/name/{name}", method=RequestMethod.DELETE)
    public String deleteCustomerByName(@PathVariable String name) {
        Long id = customerService.deleteByLastName(name);
        return "success " + id;
    }

    @ApiOperation(value="更新客户详细信息", notes="根据url的id来指定更新对象，并根据传过来的Customer信息来更新客户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "客户详细实体user", required = true, dataType = "Customer")
    })

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putCustomer(@RequestBody Customer customer) {
        // 处理"/customer/{id}"的PUT请求，用来更新User信息
        customerService.updateCustomer(customer);
        return "success";
    }

    @ApiOperation(value="删除客户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "客户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        customerService.deleteCustomer(id);
        return "success";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody Customer customer){
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer inCustomer  : customers){
            if( inCustomer.getFirstName().equals(customer.getFirstName()) &&
                    inCustomer.getLastName().equals(customer.getLastName()))
                return "login success";
        }
        return "login failed";
    }
}
