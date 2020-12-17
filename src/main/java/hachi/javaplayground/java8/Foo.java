package hachi.javaplayground.java8;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        BinaryOperator<Integer> get10 = (a, b) -> a + b;

        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;
        System.out.println(plus10.andThen(multiply2).apply(2));
    }


    public void run() {
        final int baseNumber = 10; // 사실상 final

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }
        // 익명 클래스
        // 익명 클래스와 로컬 클래스는 셰도우로 가려진다 (스코프가 같아서)
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);
        printInt.accept(10);
    }
}
