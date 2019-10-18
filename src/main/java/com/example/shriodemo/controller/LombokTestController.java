package com.example.shriodemo.controller;

import java.util.*;
import java.util.stream.Stream;

/*
 * @Author liuxin
 * @Description //TODO
 **/
public class LombokTestController {
    public static void main(String[] args) {
        //声明一个list
        List<String> list = new ArrayList<>();
        list.add("周芷若");
        list.add("张无忌");
        list.add("张三丰");
        list.add("周周");
        //正常情况过滤list元素
        for (String s : list) {
            if (s.startsWith("周")) {  //筛选姓周的
                System.out.println(s);
            }
        }
        // stream 流  核心理念  只关注实现，不关注如何实现，如fliter只是过滤，forEach只是遍历
        list.stream()
                .filter(aa -> aa.startsWith("周"))       //过滤姓周的
                .filter(aa -> aa.length() == 3)         //过滤长度为3的字符
                .forEach(aa -> System.out.println(aa));  //forEanch遍历
        // 使用stream流有两种模式，1 集合对象获取如 list.stream()   2  stream流静态方法 对象.of
        // 第一种方式示例 集合类
        //List 类
        List<String> lista = new ArrayList<>();
        list.stream();
        //Set 类
        Set<String> set = new HashSet<>();
        set.stream();
        //Map 类
        Map<String, String> map = new HashMap<>();
        //因为集合才能获取stream所以获取键，存储到一个set集合里 获取stream流
        Set<String> set1 = map.keySet();
        set1.stream();
        //获取值，存储到collection集合里，获取stream流
        Collection<String> values = map.values();
        values.stream();
        //这种方式更加简洁，entrSet 可以获取键、值映射关系
        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.stream();
        //第二种方式使用stream流静态方法of 可以用于数组
        String[] str = {"字符串", "字符串"};
        Stream.of(str);
        //Stream流的静态方法of可以传入可变参数，也就是说可以传入数组
        Stream.of("字符串", "字符串").forEach(name -> System.out.println(name));

        // Stream 流 分两种方法
        // 1 延迟方法：返回值类型任然是Stream自身类型的方法、因此支持链式调用（除了终结方法外、其余方法都是链式调用）
        // 2 终结方法：返回值类型不在是Stream自身类型的方法、因此不支持链式调用
        //Stream常用方法 forEach、filter、Map、Count、limit、skip、concat
        //forEach 方法： 遍历流中的数据属于“终结方法”、遍历之后就不能再调用了
        //获取一个流并遍历,使用Lambda表达式
        Stream.of("熊大", "熊二", "熊三", "熊四", "熊五").forEach(name -> System.out.println(name));
        //fliter 方法： 对流中元素进行过滤
        //声明一个流
        Stream<String> stringStream = Stream.of("熊大", "熊二", "李三", "熊四", "熊五");
        //对流中元素进行过滤只要李三、返回值是一个新的流
        Stream<String> stringStream1 = stringStream.filter((String name) -> {
            return name.startsWith("李");
        });
        stringStream1.forEach(name -> System.out.println(name));
        //Stream流属于管道流，只能被消费（使用）一次、第一个Stream流调用方法完毕、数据就会流转到下一个Stream流中而第一流就关闭了
        //映射Map方法： 如果需要将流中的元素转换到下一个流中可以使用Map方法
        //声明一个流
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");   //第一个流
        //使用Map方法把字符转换成整数、转换（映射）为Integer类型整数
        Stream<Integer> integerStream = stream.map((String s) -> {    //第二个流（延迟方法会返回一个新的流）
            return Integer.parseInt(s);
        });
        integerStream.forEach(i -> System.out.println(i));
        //统计Count方法： 用于统计流中元素个数、返回值为long类型、属于终结方法
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Stream<Integer> stream1 = integers.stream();  //返回一个新的流
        long count = stream1.count();
        System.out.println(count);
        //截取limit方法：用于截取流中元素、只能截取前n个、属于延迟方法
        //声明数组
        String[] arr = {"喜洋洋", "懒洋洋", "灰太狼"};
        //放入流里
        Stream<String> stream2 = Stream.of(arr);
        Stream<String> limit = stream2.limit(2);
        limit.forEach(name -> System.out.println(name));
        //跳过skip方法： 用于跳过、返回一个新的流、属于延迟方法
        String[] arrr = {"喜洋洋", "懒洋洋", "灰太狼"};
        //放入流里
        Stream<String> stream3 = Stream.of(arrr);
        Stream<String> skip = stream3.skip(2);
        skip.forEach(name -> System.out.println(name));
        //组合concat方法： 将两个流合并一个流
        Stream<String> concat1 = Stream.of("熊大", "熊二", "李三", "熊四", "熊五");
        Stream<String> concat2 = Stream.of("喜洋洋", "懒洋洋", "灰太狼");
        //把以上两个流组合成一个流
        Stream<String> concat = Stream.concat(concat1, concat2);
        concat.forEach(name -> System.out.println(name));
    }

}