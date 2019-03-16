package com.fengkun.java8.map.hostings2map;

import com.fengkun.java8.map.list2map.Hosting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : fengkun
 * @date : 19-3-17
 * 内容 ： 将List转为Map(重复key的情况)
 */
public class List2MapDuplicatedKey {

    public static void main(String[] args) {
        List<Hosting> hostings = new ArrayList<>();
        hostings.add(new Hosting(1, "liquidweb.com", 80000));
        hostings.add(new Hosting(2, "linode.com", 90000));
        hostings.add(new Hosting(3, "digitalocean.com", 120000));
        hostings.add(new Hosting(4, "aws.amazon.com", 200000));
        hostings.add(new Hosting(5, "mkyong.com", 1));

        hostings.add(new Hosting(6, "linode.com", 100000)); // 重复的key

        // key = name, vaule = websites
        Map<String, Long> name2Websites = hostings.stream()
                .collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldValue, newValue) -> newValue));
        System.out.println("name2Websites: " + name2Websites);

    }
}
