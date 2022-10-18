package com.hello.cafe.dao;


import com.hello.cafe.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {

    @Autowired
    SqlSession sqlSession;

    public void memberInsert(Member member) {
        // jdbc 6단계
        System.out.println("MemberDAO " + member.getName());
        System.out.println("member dao " + sqlSession);
        /*mapper의 namespace + id => mapper.member.memberInsert*/
        sqlSession.insert("mapper.member.memberInsert", member);
    }

    public String login(Member member) {
        return sqlSession.selectOne("mapper.member.login", member);
    }
}
