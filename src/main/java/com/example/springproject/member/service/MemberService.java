package com.example.springproject.member.service;

import com.example.springproject.member.domain.MemberVO;
import com.example.springproject.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("com.example.springproject.member.service.MemberService")
public class MemberService {
    @Resource(name="com.example.springproject.member.mapper.MemberMapper")
    MemberMapper memberMapper;

    public List<MemberVO> memberListService() throws Exception{
        return memberMapper.memberList();
    }
}
