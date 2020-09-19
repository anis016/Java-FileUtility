package com.starter.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileUtility {

    public static Path getFilePathInHomeDirectory(String fileName) throws IOException {
        // Better approach would be to use Apache CommonsIO to get the home directory
        Path homeDirectory = Paths.get(System.getProperty("user.home"));
        Path filePath = homeDirectory.resolve(fileName);
        if (!filePath.toFile().exists()) {
            Files.createFile(filePath);
            System.out.println("file created");
        } else {
            System.out.println("file exists");
        }

        return filePath;
    }

    public static void writeObjectToFile(java.io.Serializable object, Path path) throws IOException {
        if (Files.exists(path)) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(path.toString());
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                 ) {
                objectOutputStream.writeObject(object);
                System.out.println("file object written");
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        } else {
            throw new FileNotFoundException(path.toString() + " not found");
        }
    }

    public static Object readObjectFromFile(Path path) throws IOException {
        Optional<Object> optionalT = Optional.empty();
        if (Files.exists(path)) {
            try (FileInputStream fileInputStream = new FileInputStream(path.toString());
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ) {
                optionalT = Optional.ofNullable(objectInputStream.readObject());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            throw new FileNotFoundException(path.toString() + " not found");
        }
        return optionalT.orElse(null);
    }
}
