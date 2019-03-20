package com.fengkun.java8.map.filter2map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-3-19
 * 内容 ： 按key过滤返回map
 */
public class TestMapFilter2 {

    public static void main(String[] args) {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        //Map -> Stream -> Filter -> Map
        Map<Integer, String> result1 = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(h -> h.getKey(), h -> h.getValue()));

        System.out.println(result1);

        Map<Integer, String> result2 = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() <= 4)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(result2);
    }
}
