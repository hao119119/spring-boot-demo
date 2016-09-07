package com.inspur.bigdata.service;

import com.inspur.bigdata.domain.Customer;
import com.inspur.bigdata.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nobody on 2016/9/5.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findCustomer(Long id){
        return customerRepository.findOne(id);
    }

    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastNameIgnoreCase(lastName);
    }

    public Long deleteByLastName(String lastName) {
        return customerRepository.deleteByLastName(lastName);
    }

    public void deleteCustomer(Long id){
        customerRepository.delete(id);
    }


}
