package hachi.javaplayground.basic.equals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void 동등값_테스트() {
        String student1 = "eojin";
        int ssn1 = 2001;

        String student2 = "hachi";
        int ssn2 = 2001;

        String student3 = new String("eojin");

        // ==
        if (ssn1 == ssn2) {
            System.out.println("둘의 값은 같다");
        } else {
            System.out.println("둘의 값은 다르다");
        }

        if (student1 == student3) {
            System.out.println("두 학생은 다른 학교이지만 이름은 같다");
        } else {
            System.out.println("두 학생은 다른 학교임으로 이름은 같아도 다른 사람이다");
        }

        // .equals()
        if (student1.equals(student3)) {
            System.out.println("두 학생의 이름은 같다");
        } else {
            System.out.println("두 학생의 이름은 다르다");
        }
    }
}