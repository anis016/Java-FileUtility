package com.starter;

import com.starter.pojo.Person;
import com.starter.utility.FileUtility;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileWritingDemo {

    public static String generate() {
        int left = 97; // Decimal number for ASCII 'a'
        int right = 122; // Decimal number for ASCII 'z'
        int length = 5;

        Random random = new Random();
        return random.ints(left, right + 1)
                .limit(length)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public static List<Person> generateListOfPersons() {
        List<Person> personList = IntStream.range(0, 10)
                .mapToObj(person -> new Person(generate(), generate()))
                .collect(Collectors.toList());
        return personList;
    }

    public static void main(String[] args) throws IOException {
        Path personFile = FileUtility.getFilePathInHomeDirectory("person.txt");

        System.out.println("writing to file");
        List<Person> writePersonsList = generateListOfPersons();
        FileUtility.writeObjectToFile(writePersonsList, personFile);

        System.out.println("reading from file");
        List<Person> readPersonsList = (List<Person>) FileUtility.readObjectFromFile(personFile);
        readPersonsList.forEach(System.out::println);
    }
}
