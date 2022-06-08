package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class App {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        Member moon = new Member(1L, "moon", Grade.VIP);

        MemberService memberService = appConfig.memberService();
        memberService.join(moon);

        Member member = memberService.findMember(1L);
        System.out.println("new Member = " + moon.getName() + "find Member = " + member.getName());
    }
}
