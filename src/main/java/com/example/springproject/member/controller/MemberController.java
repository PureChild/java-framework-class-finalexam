package com.example.springproject.member.controller;

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

    @RequestMapping("/member") // 사용자 리스트 화면 호출
    private String memberList(Model model) throws Exception{
        model.addAttribute("list", memberService.memberListService());
        return "member/list";
    }
    @RequestMapping("/member/detail/{id}")
    private String memberDetail(@PathVariable int id, Model model) throws Exception{
        model.addAttribute("detail", memberService.memberDetailService(id));
        return "member/detail";
    }
    @RequestMapping("/member/insert") // 사용자 작성폼 호출
    private String memberInsertForm(){
        return "member/insert";
    }

    @RequestMapping("/member/insertProc")
    private String memberInsertProc(HttpServletRequest request) throws Exception{
        MemberVO member = new MemberVO();

        member.setName(request.getParameter("name"));
        member.setPassword(request.getParameter("password"));
        member.setPhoto(request.getParameter("photo"));

        memberService.memberInsertService(member);

        return "redirect:/member";
    }

    @RequestMapping("/member/update/{id}") // 사용자 수정폼 호출
    private String memberUpdateForm(@PathVariable int id, Model model) throws Exception{
        model.addAttribute("detail", memberService.memberDetailService(id));
        return "member/update";
    }

    @RequestMapping("/member/updateProc")
    private String memberUpdateProc(HttpServletRequest request) throws Exception{
        MemberVO member = new MemberVO();

        member.setName(request.getParameter("name"));
        member.setPassword(request.getParameter("password"));
        member.setPhoto(request.getParameter("photo"));
        member.setId(Integer.parseInt(request.getParameter("id")));

        memberService.memberUpdateService(member);

        return "redirect:/member";
    }

    @RequestMapping("/member/delete/{id}")
    private String memberDelete(@PathVariable int id) throws Exception{
        memberService.memberDeleteService(id);
        return "redirect:/member";
    }
}
