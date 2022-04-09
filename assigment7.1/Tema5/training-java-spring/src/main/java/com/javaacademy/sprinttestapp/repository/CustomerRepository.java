package com.javaacademy.sprinttestapp.repository;

import com.javaacademy.sprinttestapp.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

}

