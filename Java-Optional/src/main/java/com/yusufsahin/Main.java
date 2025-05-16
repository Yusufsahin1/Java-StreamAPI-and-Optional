package com.yusufsahin;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // ------------------ NullPointerException ------------------

        String name = ""; // Empty string, not null
        String name2 = null; // Null reference

        System.out.println(name);   // prints: (empty line)
        System.out.println(name2);  // prints: null

        System.out.println(name.length()); // 0

        // System.out.println(name2.length()); --> would throw NullPointerException

        String[] arr = new String[3];
        arr[0] = null;

        System.out.println(arr[0]); // prints: null

        // System.out.println(arr[0].toUpperCase()); --> would throw NullPointerException


        // ------------------ Optional.of() ------------------

        String myName = "Yusuf";
        Optional<String> optionalName = Optional.of(myName); // must NOT be null

        System.out.println("Optional content: " + optionalName);     // prints Optional[Yusuf]
        System.out.println("Optional content: " + optionalName.get()); // prints Yusuf


        // ------------------ Optional.ofNullable() ------------------

        String nullName = null;
        Optional<String> optionalName2 = Optional.ofNullable(nullName);

        System.out.println("Optional content: " + optionalName2); // prints: Optional.empty
        // System.out.println(optionalName2.get()); --> would throw NoSuchElementException


        // ------------------ isPresent() & isEmpty() ------------------

        if (optionalName.isPresent()) {
            System.out.println("Name: " + optionalName.get());
        } else {
            System.out.println("Name is null, so optional is empty.");
        }

        if (optionalName2.isPresent()) {
            System.out.println("Name: " + optionalName2.get());
        } else {
            System.out.println("Name is null, so optional is empty.");
        }

        if (optionalName2.isEmpty()) {
            System.out.println("Name is null, so optional is empty.");
        } else {
            System.out.println("Name: " + optionalName2.get());
        }


        // ------------------ ifPresent() ------------------

        optionalName.ifPresent(System.out::println);
        optionalName2.ifPresent(System.out::println);  // no output


        // ------------------ orElse() ------------------

        String result = Optional.ofNullable(myName).orElse("Default name");
        System.out.println("result: " + result);

        String result2 = Optional.ofNullable(nullName).orElse("Default name");
        System.out.println("orElse result: " + result2); // Default name


        // ------------------ filter() and map() ------------------

        String email = "user@example.com";
        Optional<String> optionalEmail = Optional.ofNullable(email);

        optionalEmail
                .filter(e -> e.contains("@"))
                .map(String::toUpperCase)
                .ifPresent(e -> System.out.println("Filtered & Mapped email: " + e));
    }
}

