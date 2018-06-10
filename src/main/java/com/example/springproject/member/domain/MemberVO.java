package com.example.springproject.member.domain;

import lombok.Data;

@Data
public class MemberVO {
    private int id;
    private String name;
    private String password;
    private String url;
    private String filename;
}
