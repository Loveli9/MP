package com.hyp.machineTest.chineseMobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;

/**
 * 输入的第一行为n（n<40）,表示有n个同学，接下来的n行每行有4个输入，
 * 分别为该学生的名字,语、数、外成绩，请按照排序规则对学生进行排序，规则如下：
 *
 * 1、总成绩高的排在前面
 * 2、总成绩相同的情况下，语文成绩高的排在前面。
 * 3、在总成绩，语文成绩都相同的情况下，数学成绩高的排在前面。
 * 4、在成绩都相同的情况下，先输入的同学排在前面。
 *
 * 输入
 * 每个测试文件的第一行包含一个整数，即同学个数。
 * 接下来的n行中的每行包含一个字符串s [i]，分别是每个同学的名字和分数。
 * 输出
 * 排好序的分数。
 *
 * 样例输入
 * 3
 * aa 70 80 75
 * bb 80 85 90
 * cc 60 65 88
 * 样例输出
 * bb 80 85 90
 * aa 70 80 75
 * cc 60 65 88
 * */
public class GradesRanking {

    public static List<Student> gradesRanking() throws Exception{
        List<Student> allStudent = new ArrayList<>();
        System.out.println("请输入学生个数：");
        String totals = new Scanner(System.in).nextLine();
        Integer studentTotal = Integer.parseInt(totals);
        if(studentTotal >= 40) {
            throw new Exception("学生人数不应该超过40人");
        }
        for(int i=0;i<studentTotal;i++) {
            System.out.println("请输入学生姓名：");
            String name = new Scanner(System.in).nextLine();
            System.out.println("请输入学生语文成绩：");
            Integer chinese = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.println("请输入学生数学成绩：");
            Integer math = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.println("请输入学生英语成绩：");
            Integer english = Integer.parseInt(new Scanner(System.in).nextLine());
            Student student = new Student(name,chinese,math,english);
            allStudent.add(student);
        }
        return allStudent;
    }

    public static List<Student> ranking(List<Student> students) {
        students.stream().forEach(
                student -> {
                    student.setTotals(student.getChinese() + student.getMath() + student.getEnglish());
                }
        );
        List<Student> resultList = students.stream()
                .sorted(comparing(Student::getTotals).reversed()
                .thenComparing(comparing(Student::getChinese)).reversed()
                        .thenComparing(comparing(Student::getMath)).reversed())
                .collect(Collectors.toList());
        return resultList;

    }

    public static void main(String[] args) {
        try {
            List<Student> students = gradesRanking();
            List<Student> out = ranking(students);
            System.out.println(out);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误信息：" + e.getMessage());
        }
    }

}
