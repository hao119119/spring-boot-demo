package com.inspur.bigdata.domain;

import com.inspur.bigdata.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nobody on 2016/8/10.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Long countByLastName(String lastName);

    @Transactional
    Long deleteByLastName(String lastName);

    List<Customer> removeByLastName(String lastName);

    List<Customer> findByEmailAddressAndLastName(String emailAddress, String lastName);

    // Enable the distinct flag for the query
    List<Customer> findDistinctPeopleByLastNameOrFirstName(String lastName, String firstName);
    List<Customer> findCustomerDistinctByLastNameOrFirstName(String lastName, String firstName);

    // Enabling ignoring case for an individual property
    List<Customer> findByLastNameIgnoreCase(String lastName);
    // Enabling ignoring case for all suitable properties
    List<Customer> findByLastNameAndFirstNameAllIgnoreCase(String lastName, String firstName);

    // Enabling static ORDER BY for a query
    List<Customer> findByLastNameOrderByFirstNameAsc(String lastname);
    List<Customer> findByLastNameOrderByFirstNameDesc(String lastname);

    // you also get support for operators such as Between, LessThan, GreaterThan, Like

    @Query("from Customer u where u.lastName=:name")
    Customer findCustomer(@Param("name") String name);




}
