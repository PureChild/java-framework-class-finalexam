package com.example.springproject.member.controller;

import com.example.springproject.member.domain.MemberVO;
import com.example.springproject.member.domain.PhotoVO;
import com.example.springproject.member.service.MemberService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

@Controller
public class MemberController {
    @Resource(name="com.example.springproject.member.service.MemberService")
    MemberService memberService;

    @RequestMapping("/member/detail/{name}")
    private String memberDetail(@PathVariable String name, Model model) throws Exception{
        model.addAttribute("detail", memberService.memberDetailService(name));
        return "member/detail";
    }
    @RequestMapping("/member/insert") // 사용자 작성폼 호출
    private String memberInsertForm(){
        return "member/insert";
    }

    @RequestMapping("/member/insertProc")
    private String memberInsertProc(HttpServletRequest request, @RequestPart MultipartFile photo) throws Exception{
        MemberVO member = new MemberVO();
        PhotoVO profile = new PhotoVO();

        member.setName(request.getParameter("name"));
        member.setPassword(request.getParameter("password"));

        if(photo.isEmpty()){ //업로드할 파일이 없을 시
            memberService.memberInsertService(member); // 유저정보 insert
        }else {
            String fileName = photo.getOriginalFilename();
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
            File destinationFile;
            String destinationFileName;
            String fileUrl = "C:/Users/SeungsooLee/Desktop/java-framework-class-finalexam/src/main/webapp/WEB-INF/profile_img/";


            do {
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                destinationFile = new File(fileUrl + destinationFileName);
            } while (destinationFile.exists());

            destinationFile.getParentFile().mkdirs();
            photo.transferTo(destinationFile);

            memberService.memberInsertService(member);

            profile.setUser_id(member.getId());
            profile.setFilename(destinationFileName);
            profile.setOriginName(fileName);
            profile.setUrl(fileUrl);

            memberService.photoInsertService(profile);
        }

        return "redirect:/";
    }

    @RequestMapping("/member/update/{name}") // 사용자 수정폼 호출
    private String memberUpdateForm(@PathVariable String name, Model model) throws Exception{
        model.addAttribute("detail", memberService.memberDetailService(name));
        return "member/update";
    }

    @RequestMapping("/member/updateProc")
    private String memberUpdateProc(HttpServletRequest request, HttpServletResponse response, @RequestPart MultipartFile photo) throws Exception{
        MemberVO member = new MemberVO();
        PhotoVO profile = new PhotoVO();

        member.setName(request.getParameter("name"));
        member.setPassword(request.getParameter("password"));
        member.setId(Integer.parseInt(request.getParameter("id")));

        if(photo.isEmpty()){ //업로드할 파일이 없을 시
            memberService.memberUpdateService(member); // 유저정보 update
        }else {
            String fileName = photo.getOriginalFilename();
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
            File destinationFile;
            String destinationFileName;
            String fileUrl = "C:/Users/SeungsooLee/Desktop/java-framework-class-finalexam/src/main/webapp/WEB-INF/profile_img/";


            do {
                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
                destinationFile = new File(fileUrl + destinationFileName);
            } while (destinationFile.exists());

            destinationFile.getParentFile().mkdirs();
            photo.transferTo(destinationFile);

            memberService.memberUpdateService(member);

            profile.setUser_id(member.getId());
            profile.setFilename(destinationFileName);
            profile.setOriginName(fileName);
            profile.setUrl(fileUrl);

            memberService.photoUpdateService(profile);
        }

        request.getSession().invalidate();

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('다시 로그인해주세요!'); location.href='/'</script>");
        out.flush();

        return "redirect:/";
    }

    @RequestMapping("/member/delete/{id}")
    private String memberDelete(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) throws Exception{
        memberService.memberDeleteService(id);

        request.getSession().invalidate();

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('안녕히가세요..'); location.href='/'</script>");
        out.flush();

        return "redirect:/";
    }

    @RequestMapping(value = "/getPhoto")
    public String getPic(String url, HttpServletRequest request) {

        request.setAttribute("path", url);

        return "/image";
    }
}
