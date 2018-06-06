package com.example.springproject.member.mapper;

import com.example.springproject.member.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;

// DB에 접근하는 클래스이므로 @Repository
@Repository("com.example.springproject.member.mapper.MemberMapper")
public interface MemberMapper {
    public int cntMember() throws Exception;

    //게시글 목록
    public List<MemberVO> memberList() throws Exception;
}
