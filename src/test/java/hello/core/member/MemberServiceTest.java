package hello.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void 회원_가입() {
        //given
        Member member = new Member(1L, "moon", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }
}