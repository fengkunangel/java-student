package com.fengkun.java8.map.list2map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-3-17
 * 内容 ： 将List转为Map并排序
 */
public class List2MapWithSort {

    public static void main(String[] args) {
        List<Hosting> hostings = new ArrayList<>();
        hostings.add(new Hosting(1, "liquidweb.com", 80000));
        hostings.add(new Hosting(2, "linode.com", 90000));
        hostings.add(new Hosting(3, "digitalocean.com", 120000));
        hostings.add(new Hosting(4, "aws.amazon.com", 200000));
        hostings.add(new Hosting(5, "mkyong.com", 1));
        hostings.add(new Hosting(6, "linode.com", 100000));

        // key = name, vaule = websites
        Map<String, Long> name2Websites = hostings.stream()
                .sorted(Comparator.comparing(Hosting::getWebsites).reversed())
                .collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldValue, newValue) -> newValue,   // 如果有相同的key,使用新key
                        LinkedHashMap::new));   // 返回ListedHashMap,保持有序

        System.out.println("name2Websites: " + name2Websites);
    }
}
