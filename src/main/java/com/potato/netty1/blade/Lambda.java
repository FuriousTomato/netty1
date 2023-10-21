package com.potato.netty1.blade;

import com.potato.netty1.entity.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student student1 = new Student(7, 17, "张三", "M", true);
        students.add(new Student(1,19,"张三","M",true));
        students.add(new Student(2,18,"李四","M",false));
        students.add(new Student(5,18,"李四","M",false));
        students.add(new Student(3,21,"王五","F",true));
        students.add(new Student(6,21,"王五","F",true));
        students.add(new Student(4,20,"赵六","F",false));
        students.add(student1);
        Stream<Student> stream = students.stream();
        List<Student> collect = stream.filter(student -> student.getAge() > 30).collect(Collectors.toList());
        System.out.println(collect.getClass());
        students.stream().map(Student::getName).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        Optional<Integer> max = new ArrayList<Integer>().stream().max(Comparator.comparingInt(Integer::intValue));
        System.out.println(max);
        Optional<Student> f = students.stream().filter(student -> Objects.equals(student.getGender(), "F")).findAny();
        System.out.println(f.get());
        System.out.println(f);
        Optional<Integer> reduce = students.stream().map(Student::getAge).reduce((age1, age2) -> age1 + age2);
        System.out.println(reduce);
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o);
        String aa = "aa";
        o.ifPresent(ss-> System.out.println(ss));
        String s = aa + null;
        System.out.println(s);
        IntSummaryStatistics intSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        long sum = intSummaryStatistics.getSum();
        System.out.println(sum);
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::isPassExam,
                Collectors.groupingBy(Student::getName, Collectors.counting()))));
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.groupingBy(Student::isPassExam))));
//        Collections.sort(students, Comparator.comparingInt(Student::getAge).reversed().thenComparingInt(Student::getId));
//        System.out.println(students);

//        Collection<Student> students1 = Collections.unmodifiableCollection(students);
//        student1.setName("王八");
//        System.out.println(students1);
//        students1.add(new Student());
//        System.out.println(students1);
    }
}
