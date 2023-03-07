package IO.Testing.Mock;

import IO.Testing.exception.BusinessLogicException;
import IO.Testing.member.entity.Member;
import IO.Testing.member.repository.MemberRepository;
import IO.Testing.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberServiceMockTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    @DisplayName("멤버 등록 테스트")
    public void createMemberTest() {
        // given
        Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");

        given(memberRepository.findByEmail(Mockito.anyString())).willReturn(Optional.of(member));

        // when // then
        assertThrows(BusinessLogicException.class, () -> memberService.createMember(member));
    }
}
