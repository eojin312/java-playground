package hachi.javaplayground.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String price;
}
