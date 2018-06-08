package com.example.springproject.member.domain;

import lombok.Data;

@Data
public class photoVO {
    private int num;
    private int user_id;
    private String filename;
    private String originName;
    private String url;
}
