package com.example.springproject;

import com.example.springproject.member.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class JspTest {
    @Resource(name="com.example.springproject.member.mapper.MemberMapper")
    MemberMapper memberMapper;

    @RequestMapping("/test")
    private String jspTest(){
        try {
            System.out.println(memberMapper.cntMember());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "test";
    }
}
