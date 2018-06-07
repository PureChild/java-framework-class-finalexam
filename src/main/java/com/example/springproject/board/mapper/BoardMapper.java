package com.example.springproject.board.mapper;

import com.example.springproject.board.domain.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

// DB에 접근하는 클래스이므로 @Repository
@Repository("com.example.springproject.board.mapper.BoardMapper")
public interface BoardMapper {
    public int cntMember() throws Exception;

    // 사용자 목록
    public List<BoardVO> memberList() throws Exception;

    // 사용자 상세
    public BoardVO memberDetail(int id) throws Exception;

    // 사용자 추가
    public int memberInsert(BoardVO member) throws Exception;

    // 사용자 삭제
    public int memberUpdate(BoardVO member) throws Exception;

    // 사용자 삭제
    public int memberDelete(int id) throws Exception;
}
