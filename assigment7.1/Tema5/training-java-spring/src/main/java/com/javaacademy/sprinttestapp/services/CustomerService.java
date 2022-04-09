package com.javaacademy.sprinttestapp.services;

import com.javaacademy.sprinttestapp.model.Customers;
import com.javaacademy.sprinttestapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customers> getAllCustomers() {
        List<Customers> customers = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }


    public void insert(Customers customer){
        customerRepository.save(customer);
    }

    public void update(Customers customer){
        customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
