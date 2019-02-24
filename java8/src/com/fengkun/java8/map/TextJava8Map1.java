package com.fengkun.java8.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-2-24
 * 内容 ： 将字符串列表转换为大写
 */
public class TextJava8Map1 {

    public static void main(String[] args) {

        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        // 在Java8之前
        List<String> alphaUpper = new ArrayList<>();
        for (String s :alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alpha);
        System.out.println(alphaUpper);

        // Java8 map
        List<String> collect1 = alpha.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect1);
    }
}
