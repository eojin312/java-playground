package hachi.javaplayground.basic.lamda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class LengthComparatorTest {

    @Test
    void compare실행_확인_테스트() {
        // 함수형 인터페이스 연습
        // BiFunction 문자열 비교 람다
        BiFunction<String, String, Integer> comp = (first, second) -> Integer.compare(first.length(), second.length());
    }
}