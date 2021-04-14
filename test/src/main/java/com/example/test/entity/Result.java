package com.example.test.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    Integer id;
    String username;
    String session_id;
}
