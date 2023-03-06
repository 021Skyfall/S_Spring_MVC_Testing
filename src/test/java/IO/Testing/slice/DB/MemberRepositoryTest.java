package IO.Testing.slice.DB;

import IO.Testing.member.entity.Member;
import IO.Testing.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("멤버 등록 테스트")
    public void saveMemberTest() {
        // given
        // 멤버 등록을 위한 스텁 데이터 생성
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");

        // when
        // 데이터 베이스에 멤버 등록
        Member savedMember = memberRepository.save(member);

        // then
        // 테스트 실행
        assertNotNull(savedMember); // 저장이 되었는지
        // 저장된 값과 원하는 값이 일치하는지
        assertTrue(member.getEmail().equals(savedMember.getEmail()));
        assertTrue(member.getName().equals(savedMember.getName()));
        assertTrue(member.getPhone().equals(savedMember.getPhone()));
    }

    @Test
    @DisplayName("멤버 이메일 조회 테스트")
    public void findByEmailTest() {
        // given
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");

        // when
        memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());

        // then
        assertTrue(findMember.isPresent());
        assertTrue(findMember.get().getEmail().equals(member.getEmail()));
    }
}
