package com.fengkun.java8.map.filter2map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-3-20
 * 内容 ： Predicate 使用
 */
public class TestMapFilter3 {

    public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet().stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {

        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        HOSTING.put(5, "aws2.amazon.com");

        Map<Integer, String> result1 = filterByValue(HOSTING, x -> x.contains("heroku"));
        System.out.println(result1);

        Map<Integer, String> result2 = filterByValue(HOSTING, x -> (x.contains("aws") || x.contains("digitalocean")));
        System.out.println(result2);

        Map<Integer, String> result3 = filterByValue(HOSTING, x -> (x.contains("aws") && !x.contains("aws2")));
        System.out.println(result3);

        Map<Integer, String> result4 = filterByValue(HOSTING, x -> x.length() <= 10);
        System.out.println(result4);
    }
}
