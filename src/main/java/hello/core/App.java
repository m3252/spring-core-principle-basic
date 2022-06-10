package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // ApplicationContext spring 의 시작. 스프링 컨테이너이다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member moon = new Member(1L, "moon", Grade.VIP);

        memberService.join(moon);

        Member member = memberService.findMember(1L);
        System.out.println("new Member = " + moon.getName() + " find Member = " + member.getName());
    }
}
