package com.javaacademy.sprinttestapp.repository;

import com.javaacademy.sprinttestapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
