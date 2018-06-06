package com.example.sympathy.controller;

import com.example.sympathy.Member;
import com.example.sympathy.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping("/list")
    public String list(Model model){
        List<Member> list = memberRepository.findAll();
        model.addAttribute("list",list);
        return "member/list";
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "member/add";
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String postAdd(Member member){
        memberRepository.save(member);
        return "redirect:/member/list";
    }

//    @RequestMapping(value="/mod/{id}",method = RequestMethod.GET)
//    public String mod(@PathVariable int id, Model model){
//        Member member = memberRepository.findOne(id);
//        model.addAttribute("data",member);
//        return "member/mod";
//    }

    @RequestMapping(value="/mod",method = RequestMethod.POST)
    public String postMod(Member member){
        memberRepository.save(member);
        return "redirect:/member/list";
    }

//    @RequestMapping("/del/{id}")
//    public String del(@PathVariable int id){
//        memberRepository.delete(id);
//        return "redirect:/member/list";
//    }
}
