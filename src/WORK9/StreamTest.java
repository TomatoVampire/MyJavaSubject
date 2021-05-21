package WORK9;

/*
* 完成以下 Stream 练习
* 将单词转为⼤写
List<String> collection = asList("My", "name", "is", "John", "Doe"); //
转化前
List<String> collection = asList("MY", "NAME", "IS", "JOHN", "DOE"); //
转化后
* 筛选字⺟⻓度小于 4 的单词
List<String> collection = asList("My", "name", "is", "John", "Doe"); //
转化前
List<String> collection = asList("My", "is", "Doe"); // 转化后
* 使⽤ flatMap 实现列表展开
List<List<String>> collection = asList(asList("Viktor", "Farcic"),
asList("John", "Doe", "Third")); // 转化前
List<String> expected = asList("Viktor", "Farcic", "John", "Doe",
"Third");// 转化后
* */

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args){
        List<String> toCap = List.of("My", "name", "is", "John", "Doe");
        List<String> toFilter = List.of("My", "name", "is", "John", "Doe");
        List<List<String>> toExpand = List.of(List.of("Viktor", "Farcic"),
                List.of("John", "Doe", "Third"));
        //单词大写
        System.out.println("单词大写：");
        System.out.println("操作前："+toCap);
        List<String> s1 = toCap.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("操作后："+s1);
        System.out.println("");

        //筛选长度小于4的单词
        System.out.println("筛选长度小于4的单词：");
        System.out.println("操作前："+toFilter);
        List<String> s2 = toFilter.stream().filter(x->x.length()<4).collect(Collectors.toList());
        System.out.println("操作后："+s2);
        System.out.println("");

        //flatmap列表展开
        System.out.println("flatmap列表展开：");
        System.out.println("操作前："+toExpand);
        List<String> s3 = toExpand.stream().flatMap(s->{
            // 将每个元素list变成字符数组
            String[] m = s.toArray(new String[0]);// 注意toArray(new String[0])的用法！
            Stream<String> st = Arrays.stream(m);
            return st;
        })
        .collect(Collectors.toList());
        System.out.println("操作后："+s3);
    }
}
