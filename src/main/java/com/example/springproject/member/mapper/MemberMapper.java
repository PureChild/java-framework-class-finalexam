package com.example.springproject.member.mapper;

import org.springframework.stereotype.Repository;

// DB에 접근하는 클래스이므로 @Repository
@Repository("com.example.springproject.member.mapper.MemberMapper")
public interface MemberMapper {
    public int cntMember() throws Exception;
}
