package hachi.javaplayground.java8;

@FunctionalInterface
// 인터페이스 정의하는 메소드 형태가 다양해짐 = 함수형 인터페이스 추상 메소드가 몇 개 있냐에 따라 함수형 인터페이스가 정해짐
public interface RunSomething {
    void doIt();

    static void printName() {
        System.out.println("eojin");
    }


    default void printAge() {
        System.out.println("19");
    }
}
