package com.fengkun.java8.comparator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : fengkun
 * @date : 19-2-23
 * 内容 ： 比较器Test
 */
public class TestSorting {

    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (Developer developer : listDevs) {
            System.out.println(developer);
        }
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("10000"), 23));

        return result;
    }
}
