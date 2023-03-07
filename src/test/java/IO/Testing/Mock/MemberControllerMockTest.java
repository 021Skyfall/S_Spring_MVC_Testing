package IO.Testing.Mock;

import IO.Testing.member.dto.MemberDto;
import IO.Testing.member.entity.Member;
import IO.Testing.member.mapper.MemberMapper;
import IO.Testing.member.service.MemberService;
import IO.Testing.stamp.Stamp;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MemberControllerMockTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    List<Member> members = new ArrayList<>();

    @BeforeEach
    void init() {
        Member member1 = new Member();
        member1.setEmail("hgd@gmail.com");
        member1.setName("홍길동");
        member1.setPhone("010-1234-5678");
        member1.setStamp(new Stamp());
        members.add(member1);

        Member member2 = new Member();
        member2.setEmail("asd@gmail.com");
        member2.setName("홍홍동");
        member2.setPhone("010-1111-2222");
        member2.setStamp(new Stamp());
        members.add(member2);
    }

    @Test
    @DisplayName("멤버 등록 테스트")
    void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com",
                "홍길동",
                "010-1234-5678");

        Member member = memberMapper.memberPostToMember(post);  // (3)
        member.setMemberId(1L);     // (4)

        // (5)
        given(memberService.createMember(Mockito.any(Member.class)))
                .willReturn(member);

        String content = gson.toJson(post);

        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/v11/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/v11/members/"))));
    }
}
