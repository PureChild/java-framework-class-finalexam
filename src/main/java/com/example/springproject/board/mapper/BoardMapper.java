package com.example.springproject.board.mapper;

import com.example.springproject.board.domain.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

// DB에 접근하는 클래스이므로 @Repository
@Repository("com.example.springproject.board.mapper.BoardMapper")
public interface BoardMapper {
    // 게시글 목록
    public List<BoardVO> boardList() throws Exception;

    // 게시글 상세
    public BoardVO boardDetail(int id) throws Exception;

    // 게시글 추가
    public int boardInsert(BoardVO member) throws Exception;

    // 게시글 수정
    public int boardUpdate(BoardVO member) throws Exception;

    // 게시글 삭제
    public int boardDelete(int id) throws Exception;

    // 공감
    public int boardLike(int id);
}
