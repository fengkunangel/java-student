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
 * 内容 ： 将一个List对象列表转换为另一个List对象列表
 */
public class TextJava8Map3 {

    public static void main(String[] args) {

        List<Developer> developers = Arrays.asList(
                new Developer("java", new BigDecimal(23231), 32),
                new Developer("c++", new BigDecimal(32432), 30),
                new Developer("spring", new BigDecimal(23121), 34)

        );
        // 在Java8之前
        List<Staff> staffs = convertToStaff(developers);
        System.out.println(staffs);

        // Java8 map
        List<Staff> result = developers.stream()
                .map(developer -> {
                    Staff staff = new Staff();
                    staff.setName(developer.getName());
                    staff.setAge(developer.getAge());
                    if ("c++".equals(developer.getName())) {
                        staff.setAddress("us");
                    }
                    return staff;
                })
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static List<Staff> convertToStaff(List<Developer> developers) {

        List<Staff> staffs = new ArrayList<>();
        for (Developer developer :developers) {
            Staff staff = new Staff();
            staff.setName(developer.getName());
            staff.setAge(developer.getAge());
            if ("java".equals(developer.getName())) {
                staff.setAddress("us");
            }
            staffs.add(staff);
        }

        return staffs;
    }
}
