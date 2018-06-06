package com.example.springproject;

import com.example.springproject.member.mapper.MemberMapper;
import com.example.springproject.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class JspTest {
    @Resource(name="com.example.springproject.member.service.MemberService")
    MemberService memberService;

    @RequestMapping("/list") //사용자 리스트 화면 호출
    private String memberList(Model model) throws Exception{
        model.addAttribute("list", memberService.memberListService());
        return "list";
    }
    @RequestMapping("/detail/{id}")
    private String memberDetail(@PathVariable int id, Model model) throws Exception{
        model.addAttribute("detail", memberService.memberDetailService(id));
        return "detail";
    }

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
