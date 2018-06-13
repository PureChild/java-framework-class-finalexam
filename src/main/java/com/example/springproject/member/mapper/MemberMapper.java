package com.example.springproject.member.mapper;

import com.example.springproject.member.domain.MemberVO;
import com.example.springproject.member.domain.PhotoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// DB에 접근하는 클래스이므로 @Repository
@Repository("com.example.springproject.member.mapper.MemberMapper")
public interface MemberMapper {
    public int cntMember() throws Exception;

    // 사용자 목록
    public List<MemberVO> memberList() throws Exception;

    // 사용자 상세
    public MemberVO memberDetail(int id) throws Exception;

    // 사용자 추가
    public int memberInsert(MemberVO member) throws Exception;
    // 프로필사진 추가
    public int photoInsert(PhotoVO profile) throws Exception;

    // 사용자 수정
    public int memberUpdate(MemberVO member) throws Exception;

    // 사용자 삭제
    public int memberDelete(int id) throws Exception;

    public int confirmMember(@Param("name") String name, @Param("password") String password) throws Exception;
}
