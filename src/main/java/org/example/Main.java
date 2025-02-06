package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
interface Calculator { //Functional Interface - Interface with only one abstract method
    int calculate(int a, int b); //Abstract Method
}

public class Main {

    static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return "Name: " + name + " Age: " + age;
        }


    }

    public static void main(String[] args) {

        System.out.println("Hello, World!");

        //Java 8 Features
        //Lambda Expressions
        //Functional Interfaces
        //Method References
        //Streams
        //Optional Class

        //Functional Interfaces
        //A functional interface is an interface that contains only one abstract method.
        //They can have only one functionality to exhibit.
        //From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface.

        //Lambda Expressions
        //Lambda expressions are used primarily to define inline implementation of a functional interface.
        //parameter -> expression body

        Calculator add = (a, b) -> a+b;
        Calculator subtract = (a, b) -> a-b;

        System.out.println(add.calculate(10, 5));
        System.out.println(subtract.calculate(10,5));

        //Built in functional interfaces in Java
        //Predicate - boolean test(T t)
        //Example
        Predicate<Integer> greaterThan = i -> i > 10;
        System.out.println(greaterThan.test(90));
        Predicate<Integer> lesserThan = i -> (i < 18);
        System.out.println(lesserThan.test(10));

        //Function - R apply(T t)
        //Example
        Function<Integer, Integer> square = i -> i * i; //Function<T, R>. First Integer is input, second Integer is output
        System.out.println(square.apply(5));

        Function<Integer, Integer> cube = i -> i*i*i;
        System.out.println(cube.apply(5));

        //Consumer - void accept(T t) - It does not return anything
        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello World");

        //Supplier - T get() - It does not take any input and returns the value
        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());

        Predicate<Integer> isEven = n -> n%2 == 0;
        System.out.println(isEven.test(10));



        //Method References - Used to refer method of functional interface - Class::method
        Function <String, Integer> parseInt = Integer::parseInt; //Method Reference
        System.out.println(parseInt.apply("10"));

        List<String> names = Arrays.asList("John", "Doe", "Jane", "Doe");

        names.forEach(System.out::println); //Method Reference
        names.forEach((name) -> System.out.println(name)); //Lambda Expression


        //Streams - A stream represents a sequence of elements and supports different kind of operations to perform computations upon those elements.
        //Stream operations are either intermediate or terminal.
        //Intermediate - map, filter, sorted, distinct
        //Terminal - forEach, collect, reduce, count, anyMatch, allMatch, noneMatch, findFirst, findAny
        //We can create a stream from a collection using stream() method

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> doubled = numbers.stream().map(i -> i*2).toList();
        doubled.forEach(System.out::println);

        List<Integer> evens = numbers.stream().filter((i -> i%2 == 0)).toList();
        evens.forEach(System.out::println);

        List<Integer> sorted = numbers.stream().sorted().toList();
        sorted.forEach(System.out::println);

        List<Integer> distinct = numbers.stream().distinct().toList();
        distinct.forEach(System.out::println);

        int sum = numbers.stream().reduce(0, (a, b) -> a+b); //here 0 - accumulator, a - current value, b - next value

        System.out.println(sum);

        //Collectors - Used to combine the result of processing on the elements of a stream
        //toList, toSet, toMap, joining, counting, summingInt, averagingInt, groupingBy, partitioningBy
        List<Integer> odds = numbers.stream().filter(i -> i%2 != 0).collect(Collectors.toList()); //Java 8

        odds.forEach(System.out::println);

        //Optional Class - It is a container object which can be null or non-null
        //It is used to represent a value is present or absent

        String name = null;
//        Optional<String> optionalName = Optional.of(name);
//        System.out.println(optionalName.isPresent());

        name = "John";
        Optional<String> optionalName = Optional.of(name);
        System.out.println(optionalName.isPresent());

        System.out.println(optionalName.get());
        //Optional Methods - isPresent, get, ifPresent, orElse, orElseGet, orElseThrow, map, filter, flatMap

        Employee e1 = new Employee("John", 30);
        Employee e2 = new Employee("Jane", 25);
        Employee e3 = new Employee("Doe", 35);

        List<Employee> employees = Arrays.asList(e1, e2, e3);
        List<Employee> emp3 = new ArrayList<>();
        employees.sort((emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
        employees.forEach(System.out::println);

        employees.sort((emp1, emp2) -> emp1.getAge() - emp2.getAge());
        employees.forEach(System.out::println);










    }
}