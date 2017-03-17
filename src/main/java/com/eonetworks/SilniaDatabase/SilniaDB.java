package com.eonetworks.SilniaDatabase;

import javax.persistence.*;

@Entity
public class SilniaDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    @Column
    private Integer number;

    @Column
    private Integer score;

    private Integer cośtam = 12345;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void ustaw() {
        number = 20;
    }
    public SilniaDB withNumber(final int number) {
        this.number = number;
        return this;
    }
}
