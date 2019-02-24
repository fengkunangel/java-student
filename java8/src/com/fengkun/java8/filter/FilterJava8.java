package com.fengkun.java8.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-2-23
 * 内容 ： Java8过滤List
 */
public class FilterJava8 {

    public static void main(String[] args) {

        List<Person> peoples = Arrays.asList(
                new Person("java", 22),
                new Person("js", 35),
                new Person("css", 31)
        );

        Person result1 = peoples.stream()
                .filter(p -> "java".equals(p.getName()))
                .findAny()
                .orElse(null);
        System.out.println(result1);

        Person result2 = peoples.stream()
                .filter(p -> "spring".equals(p.getName()))
                .findAny()
                .orElse(null);
        System.out.println(result2);

        Person result3 = peoples.stream()
                .filter((p) -> "java".equals(p.getName()) && 22 == p.getAge())
                .findAny()
                .orElse(null);
        System.out.println(result3);

        // 使用map收集
        String name = peoples.stream()
                .filter(p -> "js".equals(p.getName()))
                .map(Person::getName)
                .findAny()
                .orElse("");
        System.out.println(name);
        System.out.println("---------");

        List<String> names = peoples.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
