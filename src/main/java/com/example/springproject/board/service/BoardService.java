package com.example.springproject.board.service;

import com.example.springproject.board.domain.BoardVO;
import com.example.springproject.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("com.example.springproject.board.service.BoardService")
public class BoardService {
    @Resource(name="com.example.springproject.board.mapper.BoardMapper")
    BoardMapper boardMapper;

    public List<BoardVO> boardListService() throws Exception{
        return boardMapper.memberList();
    }

    public BoardVO boardDetailService(int id) throws Exception{
        return boardMapper.memberDetail(id);
    }

    public int boardInsertService(BoardVO board) throws Exception{
        return boardMapper.memberInsert(board);
    }

    public int boardUpdateService(BoardVO board) throws Exception{
        return boardMapper.memberUpdate(board);
    }

    public int boardDeleteService(int id) throws Exception{
        return boardMapper.memberDelete(id);
    }
}
