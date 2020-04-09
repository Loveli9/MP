package com.hyp.stringOp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSourceCode {

    @Test
    public void testSubString() {
        // eg: "123456".substring(1,2);
        final char[] value = new char[10];
        value[0] = 'a';
        value[1] = 'b';
        value[2] = 'c';
        value[3] = 'd';
        value[4] = 'e';
        value[5] = 'f';
        value[6] = 'g';
        value[7] = 'h';
        char[] copyValue = Arrays.copyOfRange(value, 2, 2+3);
        for(char x : copyValue) {
            System.out.println(x);
        }
    }

    @Test
    public void testJoin() {
        List<String> list = new ArrayList<String>();
        list.add("s1");
        list.add("s3");
        list.add("s5");
        list.add("s7");
        System.out.println(String.join(",", list));
    }

    @Test
    public void testToLowerCase() {
        String name = "HuYaPneg";
        String lowerName = name.toLowerCase();
        System.out.println(lowerName);
    }

    @Test
    public void testReplace() {
        String str = "abc***def***ghi";
        String target = "***";
        String replacement = "###";
        String result = Pattern.compile(target.toString(), Pattern.LITERAL).matcher(str).replaceAll(Matcher.quoteReplacement(replacement.toString()));
        System.out.println(result);
    }

    //正则表达式Pattern+Matcher
    @Test
    public void testRegex() {

        // 使用Pattern.compile方法编译一个正则表达式，创建一个匹配模式
        Pattern pattern = Pattern.compile("\\?|\\*");//正则表达式

        // pattern()函数返回正则表达式的字符串形式返回\?\*
        String patternStr = pattern.pattern();
        System.out.println("patternStr=" + patternStr);
        // flags()返回当前Pattern的匹配flag参数，这里并没有定义
        int flag = pattern.flags();
        System.out.println("flag=" + flag);

        // split方法对字符串进行分割
        // 123 123 456 456
        String[] splitStrs = pattern.split("123?123*456*456");
        for (int i = 0; i < splitStrs.length; i++) {
            System.out.print(splitStrs[i] + "  ");
        }
        System.out.println();

        // 123 123*456*456
        String[] splitStrs2 = pattern.split("123?123*456*456",2);
        for (int i = 0; i < splitStrs2.length; i++) {
            System.out.print(splitStrs2[i] + "  ");
        }
        System.out.println();

        Pattern p = Pattern.compile("\\d+");
        String[]str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (int i = 0; i < str.length; i++) {
            System.out.printf("str[%d] = %s\n",i, str[i]);
        }
        System.out.println();

        // Pattern.matches用给定的模式对字符串进行一次匹配，（需要全匹配时才返回true）
        System.out.println("Pattern.matches(\"\\\\d+\",\"2223\") is " + Pattern.matches("\\d+", "2223"));
        // 返回false，需要匹配到所有字符串才能返回true，这里aa不能匹配到
        System.out.println("Pattern.matches(\"\\\\d+\", \"2223aa\")is " + Pattern.matches("\\d+", "2223aa"));
        // 返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
        System.out.println("Pattern.matches(\"\\\\d+\",\"22bb23\") is " + Pattern.matches("\\d+", "22bb23"));

    }

}
