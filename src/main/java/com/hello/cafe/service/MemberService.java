package com.hello.cafe.service;

import com.hello.cafe.dao.MemberDAO;
import com.hello.cafe.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberDAO memberDAO;

    public void memberInsert(Member member) {
        memberDAO.memberInsert(member);
        System.out.println("MemberService" + member.getName());
    }

    public String login(Member member) {
        return memberDAO.login(member);
    }
}
