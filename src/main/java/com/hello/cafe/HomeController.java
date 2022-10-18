package com.hello.cafe;


import com.google.gson.JsonObject;
import com.hello.cafe.dto.Member;
import com.hello.cafe.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    MemberService memberService;

    @RequestMapping(
            value = "memberInsert.shop",
            method = RequestMethod.POST,
            produces = "application/text; charset=utf8")
    @ResponseBody
    public String memberInsert(Member member) {
        System.out.println("home controller");
        memberService.memberInsert(member);
        return member.getName() + "님 환영합니다";
    }

    @RequestMapping(value = "login.shop",
            method = {RequestMethod.POST},
            produces = "application/text; charset=utf8")
    @ResponseBody
    public String login(HttpServletRequest request) {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        JsonObject json = new JsonObject();

        try {
            Member member = new Member(id, pw);
            String name = memberService.login(member);
            if (name != null) {
                HttpSession session = request.getSession();
                session.setAttribute("member", member);

                json.addProperty("name", name);
            } else {
                json.addProperty("msg", "로그인 실패");
            }
        } catch (Exception e) {
            json.addProperty("msg", e.getMessage());
        }
        return json.toString();
    }
}
