package kz.study.debug.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_cards")
@Getter
@Setter
public class Card extends BaseModel{

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "amount")
    private int amount;
}
