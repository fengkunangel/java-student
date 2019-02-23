package com.fengkun.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : fengkun
 * @date : 19-2-23
 * 内容 ： 比较器Test(Lamdba)
 */
public class TestSortingLamdba {

    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
        listDevs.forEach(System.out::println);
        System.out.println("----------------");

        listDevs.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        listDevs.forEach(System.out::println);
        System.out.println("----------------");

        listDevs.sort(Comparator.comparing(Developer::getSalary));
        listDevs.forEach(System.out::println);
        System.out.println("----------------");

        listDevs.sort(Comparator.comparing(Developer::getSalary).reversed());
        listDevs.forEach(System.out::println);
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
