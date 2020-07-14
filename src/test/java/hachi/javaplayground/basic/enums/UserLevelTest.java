package hachi.javaplayground.basic.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLevelTest {

    @Test
    void test1() {
        String code = "BA";
        UserLevel userLevel = UserLevel.findByCode(code);
        assertEquals(UserLevel.BASIC, userLevel);
    }
}