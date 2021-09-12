package hachi.javaplayground.newJava8;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RunSomthingTest {

    // 함수형 인터페이스
    @Test
    void doIt() {
        RunSomthing runSomthing = () -> System.out.println("ejlee");
    }
}
