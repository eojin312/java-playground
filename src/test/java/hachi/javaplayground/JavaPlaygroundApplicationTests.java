package hachi.javaplayground;


import com.querydsl.jpa.impl.JPAQueryFactory;
import hachi.javaplayground.entity.Item;
import hachi.javaplayground.entity.QItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
@Transactional
class JavaPlaygroundApplicationTests {

    @Autowired
    private EntityManager em;

    @Test
    void contextLoads() {

    }

    @Test
    void query_dsl_entity_잘되는지_확인() {
        Item item = new Item();
        em.persist(item);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QItem qItem = QItem.item;

        Item result = query
                .selectFrom(qItem)
                .fetchOne();

        Assertions.assertThat(result).isEqualTo(item);
        Assertions.assertThat(result.getId()).isEqualTo(item.getId());
    }

    @Test
    void inputStream() {
        try {
            InputStream inputStream = new FileInputStream("/Users/user/IdeaProjects/java-playground-new/h2-2019-03-13.zip");
            while(true) {
                int i = inputStream.read();
                System.out.println(i + "h2");
                if (i == -1) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
