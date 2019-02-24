package com.fengkun.java8.map;

import com.fengkun.java8.comparator.Developer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-2-24
 * 内容 ： 获取List对象列表中某个属性的集合
 */
public class TextJava8Map2 {

    public static void main(String[] args) {

        List<Developer> developers = Arrays.asList(
                new Developer("java", new BigDecimal(23231), 32),
                new Developer("c++", new BigDecimal(32432), 30),
                new Developer("spring", new BigDecimal(23121), 34)

        );
        // 在Java8之前
        List<String> names1 = new ArrayList<>();
        for (Developer developer : developers) {
            names1.add(developer.getName());
        }
        System.out.println(names1);

        // Java8 map
        List<String> names2 = developers.stream()
                .map(developer -> developer.getName())
                .collect(Collectors.toList());
        System.out.println(names2);


    }
}
