package com.example.springproject.board.controller;

import com.example.springproject.board.domain.BoardVO;
import com.example.springproject.board.service.BoardService;
import com.example.springproject.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BoardController {
    @Resource(name="com.example.springproject.board.service.BoardService")
    BoardService boardService;
    @Resource(name="com.example.springproject.member.service.MemberService")
    MemberService memberService;

    @RequestMapping("/") // 게시글 리스트 화면 호출
    private String boardList(Model model) throws Exception{
        model.addAttribute("list", boardService.boardListService());
        return "board/list";
    }
    @RequestMapping("/detail/{id}")
    private String boardDetail(@PathVariable int id, Model model) throws Exception{
        model.addAttribute("detail", boardService.boardDetailService(id));
        return "board/detail";
    }
    @RequestMapping("/insert") // 게시글 작성폼 호출
    private String boardInsertForm(){
        return "board/insert";
    }

    @RequestMapping("/insertProc")
    private String boardInsertProc(HttpServletRequest request) throws Exception{
        BoardVO board = new BoardVO();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setUser(request.getParameter("user"));

        boardService.boardInsertService(board);

        return "redirect:/";
    }

    @RequestMapping("/update/{id}") // 게시글 수정폼 호출
    private String boardUpdateForm(@PathVariable int id, Model model) throws Exception{
        model.addAttribute("detail", boardService.boardDetailService(id));
        return "board/update";
    }

    @RequestMapping("/updateProc")
    private String boardUpdateProc(HttpServletRequest request) throws Exception{
        BoardVO board = new BoardVO();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setBno(Integer.parseInt(request.getParameter("bno")));

        boardService.boardUpdateService(board);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    private String boardDelete(@PathVariable int id) throws Exception{
        boardService.boardDeleteService(id);
        return "redirect:/";
    }

    @RequestMapping("/like/{id}")
    private String boardLike(@PathVariable int id) throws Exception{
        boardService.boardLikeService(id);
        return "redirect:/detail/{id}";
    }

    @RequestMapping("/login")
    private String login(){
        return "login";
    }

    @RequestMapping("/login_confirm")
    private String login(HttpServletRequest request) throws Exception{
//        int confirm = memberService.confirmMember(request.getParameter("name"),request.getParameter("password"));
        String returnURL = "";
        // DB에 있는 유저일 경우 세션 키 생성
        if(request.getParameter("name").equals("test") && request.getParameter("password").equals("test")){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("login_user", request.getParameter("name"));
            request.getSession().setAttribute("login", map);
            returnURL = "redirect:/";
            //일치하지 않으면 로그인페이지 재이동
        }else {
//            returnURL = "redirect:/login";
        }
        return returnURL;
    }
}
