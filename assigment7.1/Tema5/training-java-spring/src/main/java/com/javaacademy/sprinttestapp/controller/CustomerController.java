package com.javaacademy.sprinttestapp.controller;

import com.javaacademy.sprinttestapp.model.Customers;
import com.javaacademy.sprinttestapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customers> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody Customers customers) {
        List<Customers> customersList = customerService.getAllCustomers();
        ResponseCookie springCookie= ResponseCookie.from("user-id", "notloggedin").httpOnly(true).secure(true).path("/").maxAge(7 * 24 * 60 * 60).domain("localhost").build();
        for (Customers customers1 : customersList){
            if(customers1.getUsername().equals(customers.getUsername()) && customers1.getPassword().equals(customers.getPassword())) {
                ResponseCookie springCookie1 = ResponseCookie.from("user-id", "loggedin").httpOnly(true).secure(true).path("/").maxAge(7 * 24 * 60 * 60).domain("localhost").build();
                return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie1.toString()).build();
            }
        }
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).build();
    }

    @PostMapping("/customers/register")
    public Customers createCustomer(@RequestBody Customers customers){
        customerService.insert(customers);
        return customers;
    }

    @PostMapping("/customers/update")
    public Customers updateCustomer(@RequestBody Customers customers){
        customerService.update(customers);
        return customers;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
    }
}