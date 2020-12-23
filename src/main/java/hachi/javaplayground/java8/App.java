package hachi.javaplayground.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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
        List<OnlineClass> springClass = new ArrayList<>();
        springClass.add(new OnlineClass(1, "springboot", true));
        springClass.add(new OnlineClass(2, "springboot data jpa", true));
        springClass.add(new OnlineClass(3, "springboot mvc", false));
        springClass.add(new OnlineClass(4, "rest api develop", false));

        List<OnlineClass> javaClass = new ArrayList<>();
        javaClass.add(new OnlineClass(5, "java Test", true));
        javaClass.add(new OnlineClass(6, "java 8", true));
        javaClass.add(new OnlineClass(7, "java 11", false));
        javaClass.add(new OnlineClass(8, "java code manipulation", false));

        List<List<OnlineClass>> eojinEvents = new ArrayList<>();
        eojinEvents.add(springClass);
        eojinEvents.add(javaClass);

        System.out.println("spring 으로 시작하는 제목");
        springClass
                .stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getTitle()));

        System.out.println("close 되지 않은 수업");
        springClass
                .stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getTitle()));
    }

}
