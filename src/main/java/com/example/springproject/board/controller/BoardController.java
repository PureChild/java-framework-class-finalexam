package com.example.springproject.board.controller;

import com.example.springproject.board.domain.BoardVO;
import com.example.springproject.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
    @Resource(name="com.example.springproject.board.service.BoardService")
    BoardService boardService;

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
}
