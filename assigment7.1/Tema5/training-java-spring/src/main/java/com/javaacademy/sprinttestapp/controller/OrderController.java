package com.javaacademy.sprinttestapp.controller;

import com.javaacademy.sprinttestapp.model.Orders;
import com.javaacademy.sprinttestapp.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrdersService ordersService;


}
