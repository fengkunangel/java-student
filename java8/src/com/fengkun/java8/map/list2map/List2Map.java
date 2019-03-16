package com.fengkun.java8.map.list2map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-3-16
 * 内容 ： 将List转为Map
 */
public class List2Map {

    public static void main(String[] args) {
        List<Hosting> hostings = new ArrayList<>();
        hostings.add(new Hosting(1, "liquidweb.com", 80000));
        hostings.add(new Hosting(2, "linode.com", 90000));
        hostings.add(new Hosting(3, "digitalocean.com", 120000));
        hostings.add(new Hosting(4, "aws.amazon.com", 200000));
        hostings.add(new Hosting(5, "mkyong.com", 1));

        // key = id, value = websites
        Map<Integer, String> id2Name = hostings.stream()
                .collect(Collectors.toMap(Hosting::getId, Hosting::getName));
        System.out.println("id2Name: " + id2Name);

        // key = name, value = websites
        Map<String, Long> name2Websites = hostings.stream()
                .collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
        System.out.println("name2Websites: " + name2Websites);

        // key = id, value = websites
        Map<Integer, String> id2NamDifferent = hostings.stream()
                .collect(Collectors.toMap(h -> h.getId(), h -> h.getName()));
        System.out.println("id2NamDifferent: " + id2NamDifferent);

    }
}
