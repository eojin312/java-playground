package hachi.javaplayground.basic.lamda;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LengthComparatorTest {

    @Test
    void compare실행_확인_테스트() {
        // 함수형 인터페이스 연습
        // BiFunction 문자열 비교 람다
        BiFunction<String, String, Integer> comp = (first, second) -> Integer.compare(first.length(), second.length());
    }
    @Test
    void 생성자_레퍼런스_테스트() {
        List<String> labels = new ArrayList<>();
        Stream<Button> stream = labels.stream().map(Button::new);
        List<Button> buttons = stream.collect(Collectors.toList());
    }
}