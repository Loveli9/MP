package com.hyp.machineTest.chineseMobile;

import java.util.Scanner;

/**
 * 牛牛和妞妞去海边捡了一大袋美丽的贝壳，千辛万苦地运回家后，牛牛和妞妞打算分掉这些贝壳。
 * 牛牛提出，他和妞妞轮流从还没有分配的贝壳中取一定数量的贝壳，直到贝壳分完为止。
 * 分配规则是牛牛每次取剩余贝壳的1/10（向下取整），妞妞每次固定取m个贝壳，妞妞先取。
 * 妞妞想要得到不少于一半的贝壳，又不想太过分，
 * 那么她一次最少取多少个贝壳才能得到不少于一半的贝壳呢？
 *
 * 输入
 * 一个正整数n，表示贝壳的总数量，1<=n<=1000000000000000000。
 * 输出
 * 一个正整数m，表示妞妞一次最少取的贝壳数量。
 *
 * 样例输入
 * 70
 * 样例输出
 * 3
 * */
public class Shell {

    public static void importData() throws Exception{
        System.out.println("请输入贝壳个数：");
        Integer totals = Integer.parseInt(new Scanner(System.in).nextLine());
        if(totals > 1000000000000000000L) {
            throw new Exception("贝壳个数超过限制");
        }
    }

    public static void main(String[] args) {
        try {
            importData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
