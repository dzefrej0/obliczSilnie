package com.eonetworks.SilniaDatabase;

import javax.persistence.*;

@Entity
public class SilniaDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int number;



    public int getNumber() {
        return number;
    }

    public void setNumber (int number){this.number=number;}


    public SilniaDB setNumber1(int number) {
        this.number = number;
        return this;
    }

    public SilniaDB withNumber(final int number) {
        this.number = number;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                "number=" + number +
                '}';
    }
}