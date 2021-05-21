package WORK10;

//累加和累乘

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        //累加和累乘
        List<Integer> number = List.of(1,2,3,4,5,6); // 输入
        System.out.println("数组："+number);
        int addsum = number.stream().reduce(0,Integer::sum);
        System.out.println("累加结果："+addsum);
        int mulsum = number.stream().reduce(1,(res,now)->res*now);
        System.out.println("累乘结果："+mulsum + "\n");

        //筛选出年龄小于18的人名 Set<String>
        List<Person> persons = List.of(new Person("Masashi", 14), new
                Person("Nori", 40), new Person("Yasu", 42), new Person("Toshiro", 5));
        System.out.println("人："+persons);
        Set<String> less18 = persons.stream().filter(person->person.getAge()<=18).map(person->person.getName()).collect(Collectors.toSet());
        System.out.println("年龄小于18："+less18+"\n");

        //统计字符串出现的次数 Map<String, long>
        List<String> strs = List.of("one", "two", "three", "three", "two",
                "three");
        System.out.println("字符串："+ strs);
        Map<String,Long> freq = strs.stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println("出现频率："+freq);

    }
}

class Person{
    private String name;
    private int age;
    public Person(String n, int a){
        name = n;
        age = a;
    }
    public String getName(){return name;}
    public int getAge(){return age;}
    @Override
    public String toString(){
        return name + ": "+ age;
    }
}
