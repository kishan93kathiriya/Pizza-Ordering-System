package com.challange.PizzaOrderingSystem.Model;

import java.util.Date;

// Object File that represents ValueObject/bean/
public class PizzaOrderVO implements Comparable<PizzaOrderVO> {

    private String name;
    private Date date;

    public PizzaOrderVO(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(PizzaOrderVO orderObj) {
        if (orderObj.getDate() == null || orderObj.getDate() == null) {
            return 0;
        }
        return getDate().compareTo(orderObj.getDate());
    }

}
