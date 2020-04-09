package com.hyp.java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Utils {

    public static List<String> testFilter(List<String> names, Predicate<String> condition) {
        List<String> out = names.stream().filter((name) -> (condition.test(name))).collect(Collectors.toList());
        return out;
    }

    public static void main(String[] args){
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        System.out.println(testFilter(languages, (str)->str.contains("a")));
        System.out.println(testPredicate(languages));
        System.out.println(testMap(languages));
        IntSummaryStatistics stats = getValue(primes);
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    public static List<String> testPredicate (List<String> names) {
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        List<String> out = names.stream().filter(startsWithJ.and(fourLetterLong)).collect(Collectors.toList());
        return out;
    }

    public static String testMap (List<String> names) {
        String G7Countries = names.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        return G7Countries;
    }

    public static IntSummaryStatistics getValue (List<Integer> primes) {
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        Integer max = primes.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("max=" + max);
        Integer min = primes.stream().min(Comparator.comparing(Integer::intValue)).get();
        System.out.println("min=" + min);
        Integer sum = primes.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum=" + sum);
        return stats;
    }

    @Test
    public void test1() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        String out = idList.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(","));
        System.out.println(out);
    }

}
