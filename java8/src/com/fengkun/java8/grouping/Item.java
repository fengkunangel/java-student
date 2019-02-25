package com.fengkun.java8.grouping;

import java.math.BigDecimal;

/**
 * @author : fengkun
 * @date : 19-2-25
 * 内容 ： 实体
 */
public class Item {

    private String name;

    private int qty;

    private BigDecimal price;

    public Item() {
    }

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
