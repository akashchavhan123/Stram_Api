package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamProgram {
    public static void main(String args[]) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(24);


        System.out.println("********For Each***********");
        Consumer<Integer> consumer = n -> {System.out.println(n+2);};
        list.forEach(consumer);

        System.out.println("********Map***********");
        Function<Integer,Integer> method = n -> n*2;
        list.stream().map(method).forEach(n -> System.out.println(n));;

        System.out.println("********Filter***********");
        Predicate<Integer> element = num -> num%2 == 0;
        list.stream().filter(element).forEach(System.out::println);

        System.out.println("********Collect***********");
        List<Integer> collectNumbers = list.stream().filter(element).collect(Collectors.toList());
        System.out.println(collectNumbers);

        System.out.println("********Sorted***********");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("********Sorted in Descending***********");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("********Min***********");
        Integer min = list.stream().min(Integer::compare).get();
        System.out.println(min);

        System.out.println("********Max***********");
        Integer max = list.stream().max(Integer::compare).get();
        System.out.println(max);

        System.out.println("********findFirst***********");
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first);

        System.out.println("********findFirstEvenNumber***********");
        Predicate<Integer> isEvenFunction =((n)-> n%2==0);
        Integer first1 = list.stream().filter(isEvenFunction).
                peek(n -> System.out.println("peek even number is "+n)).findFirst().orElse(null);

        System.out.println("********anyMatch and allMatch***********");
        boolean allEven = list.stream().allMatch(isEvenFunction);
        boolean oneEven = list.stream().anyMatch(isEvenFunction);
        boolean nonMultiplyOfThree = list.stream().noneMatch(n -> n>0 && n%3 == 0);
        System.out.println("all even "+allEven+" One even "+oneEven+" Multiply Of 3 "+nonMultiplyOfThree);


    }
}
