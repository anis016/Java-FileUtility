package com.starter;

import com.starter.pojo.Person;
import com.starter.utility.FileUtility;

import java.io.IOException;
import java.nio.file.Path;

public class FileWritingDemo {

    public static void main(String[] args) throws IOException {
        Path personFile = FileUtility.getFilePathInHomeDirectory("person.txt");
        Person person1 = new Person("Sayed Anisul", "Hoque");
        FileUtility.writeObjectToFile(person1, personFile);

        Person readPerson = (Person) FileUtility.readObjectFromFile(personFile);
        System.out.println(readPerson.toString());
    }
}
