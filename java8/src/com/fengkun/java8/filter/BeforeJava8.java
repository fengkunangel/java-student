package com.fengkun.java8.filter;

import java.util.Arrays;
import java.util.List;

/**
 * @author : fengkun
 * @date : 19-2-23
 * 内容 ： Java8之前过滤List
 */
public class BeforeJava8 {

    public static void main(String[] args) {

        List<Person> peoples = Arrays.asList(
                new Person("java", 22),
                new Person("js", 35),
                new Person("css", 31)
        );

        Person result = getStudentByName(peoples, "java");
        System.out.println(result);

    }

    private static Person getStudentByName(List<Person> peoples, String name) {
        Person result = null;
        for (Person person : peoples) {
            if (name.equals(person.getName())) {
                result = person;
            }
        }
        return result;
    }
}
