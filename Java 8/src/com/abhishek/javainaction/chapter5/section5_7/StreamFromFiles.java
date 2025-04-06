package com.abhishek.javainaction.chapter5.section5_7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromFiles {
    public static void main(String[] args) throws IOException {
        long uniquewords = 0;
        try (
                Stream<String> lines = Files.lines(
                        Paths.get("C:\\Abhishek\\Java\\Java-Features\\Java 8\\src\\com\\abhishek\\javainaction\\chapter5\\section5_7\\filetest.txt"),
                        Charset.defaultCharset())
        ) {
            uniquewords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniquewords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
