package com.javaacademy.sprinttestapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String password;

    private String city;
    private String country;
    @OneToMany
    private List<Orders> orders;



}
