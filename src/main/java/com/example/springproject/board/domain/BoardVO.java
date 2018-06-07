package com.example.springproject.board.domain;

import lombok.Data;

@Data
public class BoardVO {
    private int bno;
    private String title;
    private String content;
    private String user;
    private int cntLike;
}
