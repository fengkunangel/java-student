package com.fengkun.java8.map.list2map;

/**
 * @author : fengkun
 * @date : 19-3-16
 * 内容 ： 实体
 */
public class Hosting {

    private int id;

    private String name;

    private long websites;

    public Hosting(int id, String name, long websites) {
        this.id = id;
        this.name = name;
        this.websites = websites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        return "Hosting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", websites=" + websites +
                '}';
    }
}
