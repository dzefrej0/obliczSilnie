package com.eonetworks.SilniaDatabase;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class SilniaDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    @Column
    private int number;
    @Column
    private BigInteger result;


    public int getNumber() {
        return number;
    }

    public void setNumber (int number){this.number=number;}


    public SilniaDB setNumberForDB(int number) {
        this.number = number;
        return this;
    }

    public SilniaDB withNumber(final int number) {
        this.number = number;
        return this;
    }


    public SilniaDB withResult(final BigInteger result) {
        this.result = result;
        return this;
    }


    @Override
    public String toString() {
        return "TaskEntity{" +
                "number=" + number +
                '}';
    }

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }
}