package hachi.javaplayground.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static List<String> show() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        List<String> collect = stringList.stream()
                .map((s) -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        stringList.forEach(System.out::println);
        return stringList;
    }

    public static void main(String[] args) {
        show();
    }

}
