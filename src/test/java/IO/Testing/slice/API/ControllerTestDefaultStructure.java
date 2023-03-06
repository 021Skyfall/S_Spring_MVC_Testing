package IO.Testing.slice.API;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTestDefaultStructure {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postMemberTest() {
        // Given : 테스트용 request body 생성
        // When : MockMvc 객체로 테스트 대상 Controller 호출
        // Then : Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 response body 검증
    }
}
