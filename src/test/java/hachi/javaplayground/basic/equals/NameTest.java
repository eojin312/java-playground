package hachi.javaplayground.basic.equals;

import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void primitive_type_는는비교() {
        // given
        int a = 1;
        int b = 1;

        // when
        boolean actual = (a == b);

        // then
        assertTrue(actual);
    }

    @Test
    void primitive_type_이퀄비교() {
        int a = 1;
        int b = 1;
        // boolean actual = (a.equals(b));  //a는 primitive type이라 equals메소드가 없다 -> 빨간줄 간다
        // assertTrue(actual);
    }

    @Test
    void 일반클래스타입_는는비교() {
        // given
        Item airpot1 = Item.builder().id(1).name("에어팟프로").price(320000).build();
        Item airpot2 = Item.builder().id(1).name("에어팟프로").price(320000).build();

        // when
        boolean actual = (airpot1 == airpot2);

        // then
        assertFalse(actual); // 클래스 타입으로 생성된 객체의 는는 비교는 주소(reference)의 비교라서, 각각 생성된 객체의 주소값은 당근 서로 다를 것이다. 그러니까 false
    }

    @Test
    void 일반클래스타입_이퀄비교_equal을override하지않음() {
        // given
        Item airpot1 = Item.builder().id(1).name("에어팟프로").price(320000).build();
        Item airpot2 = Item.builder().id(1).name("에어팟프로").price(320000).build();

        // when
        boolean actual = (airpot1.equals(airpot2));

        // then
        assertFalse(actual); // 같을 것 같지만... Object class의 equals()는 this == obj 라서 사실상 는는 비교다. 결국 객체의 주소(reference)를 서로 비교하니, 당근 "서로 다르다"로 되는 것
    }

    @Test
    void 일반클래스타입_이퀄비교_equal을override해서_모든항목의값이같을때_같다_라고_정의() {
        // given
        ItemEnhanced airpot1 = ItemEnhanced.builder().id(1).name("에어팟프로").price(320000).build();
        ItemEnhanced airpot2 = ItemEnhanced.builder().id(1).name("에어팟프로").price(320000).build();

        // when
        boolean actual = (airpot1.equals(airpot2));

        // then
        assertTrue(actual); // 모든 항목의 값이 모두 같을때 "같다"라고 equals를 override 했으므로, 두 객체의 equals비교의 결과는 true
    }

    @Test
    void 그렇다면_String클래스의리터럴선언방식에서_는는비교는() {

        // given
        String a = "123";
        String b = "123";

        // when
        boolean actual = (a == b);

        assertTrue(actual); // 리터럴선언 시 intern()메소드가 호출되면서 string constant pool에 이미 동일한 문자열이 존재하는 확인해보고, 있으면 재활용하기때문에, 위 케이스처럼 "123"으로 문자열이 같으면 pool내의 동일한 녀석을 가리키고 있을 것. 그러니까 는는비교도 같다
    }

    @Test
    void 그렇다면_String클래스의리터럴선언방식에서_이퀄즈비교는() {

        // given
        String a = "123";
        String b = "123";

        // when
        boolean actual = (a.equals(b));

        assertTrue(actual); // String클래스에서 재정의한 equals는 는는 비교가 아닌 데이터값 비교아다.
    }

    @Test
    void 그렇다면_String클래스를new로생성_는는비교는() {

        // given
        String a = new String("123");
        String b = new String("123");

        // when
        boolean actual = (a == b);

        // then
        assertFalse(actual); // 힙에 각각 생성되니까, 당근 주소가 서로 다를테고, 그러니까 는는비교 시 false가 됨
    }

    @Test
    void 그렇다면_String클래스를new로생성_이퀄즈비교는() {

        // given
        String a = new String("123");
        String b = new String("123");

        // when
        boolean actual = (a.equals(b));

        // then
        assertTrue(actual); // 같다. 이유는 String class에서 override한 equals는 주소비교가 아닌 데이터값 비교이기때문에 당근 같다.
    }
}

@Getter
class Item {
    private long id;
    private String name;
    private int price;

    @Builder
    public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

@Getter
class ItemEnhanced {
    private long id;
    private String name;
    private int price;

    @Builder
    public ItemEnhanced(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItemEnhanced) {
            ItemEnhanced target = (ItemEnhanced) obj;
            boolean isSameId = this.id == target.getId();
            boolean isSameName = this.name.equals(target.getName());
            boolean isSamePrice = this.price == target.getPrice();
            return isSameId && isSameName && isSamePrice;
        } else {
            return false;
        }
    }
}