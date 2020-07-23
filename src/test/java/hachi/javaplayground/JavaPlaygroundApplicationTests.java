package hachi.javaplayground;



import com.querydsl.jpa.impl.JPAQueryFactory;
import hachi.javaplayground.entity.Item;
import hachi.javaplayground.entity.QItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        QItem qItem = new QItem("i");
    }

}
