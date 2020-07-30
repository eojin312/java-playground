package hachi.javaplayground;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hachi.javaplayground.entity.Item;
import hachi.javaplayground.entity.Member;
import hachi.javaplayground.entity.QMember;
import hachi.javaplayground.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class QueryDslBasicTest {

    @Autowired
    private EntityManager em;

    @BeforeEach
    public void before() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("hachi", 10, teamA);
        Member member2 = new Member("eojin", 10, teamA);
        Member member3 = new Member("soriegedon", 10, teamB);
        Member member4 = new Member("kelly", 10, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    void startJPQL() {
        Member findMember = em.createQuery("select m from Member m" +
                " where m.username = :username", Member.class)
                .setParameter("username", "hachi")
                .getSingleResult();

        Assertions.assertThat(findMember.getUsername()).isEqualTo("hachi");
    }

    @Test
    void startQuerydsl() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QMember m = new QMember("m");

        Member findMember = queryFactory
                .select(m)
                .from(m)
                .where(m.username.eq("hachi"))
                .fetchOne();

        Assertions.assertThat(findMember.getUsername()).isEqualTo("hachi");
    }
}
