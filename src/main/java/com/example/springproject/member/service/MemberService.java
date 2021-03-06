package com.example.springproject.member.service;

import com.example.springproject.member.domain.MemberVO;
import com.example.springproject.member.domain.PhotoVO;
import com.example.springproject.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("com.example.springproject.member.service.MemberService")
public class MemberService {
    @Resource(name="com.example.springproject.member.mapper.MemberMapper")
    MemberMapper memberMapper;

    public List<MemberVO> memberListService() throws Exception{
        return memberMapper.memberList();
    }

    public MemberVO memberDetailService(String name) throws Exception{
        return memberMapper.memberDetail(name);
    }

    public int memberInsertService(MemberVO member) throws Exception{
        return memberMapper.memberInsert(member);
    }
    public int photoInsertService(PhotoVO profile) throws Exception{
        return memberMapper.photoInsert(profile);
    }

    public int memberUpdateService(MemberVO member) throws Exception{
        return memberMapper.memberUpdate(member);
    }
    public int photoUpdateService(PhotoVO profile) throws Exception{
        return memberMapper.photoUpdate(profile);
    }

    public int memberDeleteService(int id) throws Exception{
        return memberMapper.memberDelete(id);
    }

    public int confirmMember(String name, String password) throws Exception {
        return memberMapper.confirmMember(name, password);
    }
}
