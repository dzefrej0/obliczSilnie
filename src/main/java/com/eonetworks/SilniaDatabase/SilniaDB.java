package com.eonetworks.SilniaDatabase;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class SilniaDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private int Id;

    @Column
    private int number;

    @Column
    private BigInteger result;


    public int getNumber() {
        return number;
    }

    public void setNumber (int number){this.number=number;}


    public SilniaDB setNumberForDB(int number) {
//        if(number==0){
//            System.out.println("zero zero");
//        }
        this.number = number;
        return this;
    }

    public SilniaDB withNumber(final int number) {
        this.number = number;
        return this;
    }


    public SilniaDB withResult(final BigInteger result) {
//        if(number==0){
//            System.out.println("    zero0");
//        }

        this.result = result;
        return this;
    }

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }
}