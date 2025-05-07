package com.yusufsahin;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Task1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //Each number in the list is squared and collected into a new list.
        List<Integer> result = numbers.stream().map(num -> num * num).toList();
        System.out.println(result);

        //Task2
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "orange");
        //Strings containing the letter 'a' or 'A' are filtered.
        List<String> result2 = fruits.stream().filter(word -> word.contains("a") || word.contains("A")).toList();
        System.out.println(result2);

        //Task3
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //The sum of all odd numbers in the list is calculated.
        int result3 = numbers2.stream().filter(num -> num % 2 !=0).mapToInt(num -> num).sum();
        System.out.println(result3);

        //Task4
        List<String> vehicles = Arrays.asList("car", "airplane", "bus", "train", "bike");
        //Strings are sorted in ascending order based on their length.
        List<String> result4 = vehicles.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(result4);

        //Task5
        int[][] numbers2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8}
        };
        //Even numbers in a 2D array are squared, sorted, and collected into a list.
        List<Integer> result5 = Arrays.stream(numbers2D) // Stream<int[]>
                .flatMapToInt(Arrays::stream) // IntStream
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .sorted()
                .boxed().toList(); // boxed -> int to Integer

        System.out.println(result5);

        //Task6
        List<String> names = Arrays.asList("alice", "bob", "alice", "carol");
        //Converts each element in the list to uppercase and collects them into a Set.
        Set<String> result6 = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        System.out.println(result6);

        //Task7
        class Student {
            final String name;
            final int grade;

            Student(String name, int grade) {
                this.name = name;
                this.grade = grade;
            }

            String getName() {
                return name;
            }

            int getGrade() {
                return grade;
            }
        }

        List<Student> students = Arrays.asList(
                new Student("Yusuf", 85),
                new Student("Ahmet", 65),
                new Student("Ali", 90),
                new Student("Mahmut", 55)
        );
        //Filters students with a grade of 70 or higher and collects their names into a list.
        List<String> passedStudentNames = students.stream()
                .filter(student -> student.grade > 70)
                .map(Student::getName)
                .toList();

        System.out.println(passedStudentNames);

    }
}