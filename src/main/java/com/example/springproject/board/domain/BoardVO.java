package com.example.springproject.board.domain;

import lombok.Data;

@Data
public class BoardVO {
    private int id;
    private String name;
    private String password;
    private String photo;
}
