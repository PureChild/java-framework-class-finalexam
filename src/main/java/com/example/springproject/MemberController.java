package com.example.springproject;

import com.example.springproject.member.domain.MemberVO;
import com.example.springproject.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
    @Resource(name="com.example.springproject.member.service.MemberService")
    MemberService memberService;

    @RequestMapping("/list") // 사용자 리스트 화면 호출
    private String memberList(Model model) throws Exception{
        model.addAttribute("list", memberService.memberListService());
        return "list";
    }
    @RequestMapping("/detail/{id}")
    private String memberDetail(@PathVariable int id, Model model) throws Exception{
        model.addAttribute("detail", memberService.memberDetailService(id));
        return "detail";
    }
    @RequestMapping("/insert") // 사용자 작성폼 호출
    private String memberInsertForm(){
        return "insert";
    }

    @RequestMapping("/insertProc")
    private int memberInsertProc(HttpServletRequest request) throws Exception{
        MemberVO member = (MemberVO) request.getParameterMap();
        return memberService.memberInsertService(member);
    }
}
