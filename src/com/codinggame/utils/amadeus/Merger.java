package com.codinggame.utils.amadeus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Merger {

    public static String SRC_PROJECT = "/src/";
    public static String JAVA_PROJECT = "com.codinggame.decembre";
    public static String MAIN_CLASS = "Player";
    public static String JAVA_EXTENSION = ".java";

    static Map<String, CodeFile> files = new HashMap<>();

    public static void main(String[] args) {
        try {
            // Get current path
            String current = new File(".").getCanonicalPath();
            System.out.println("Current dir:" + current);

            Stream<Path> walk = Files.walk(Paths.get(current+SRC_PROJECT+JAVA_PROJECT.replace('.','/')));
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            // Read all the java class into CodeFile
            for(String fileName: result){
                files.put(fileName, new CodeFile(fileName));
            }

            // create the new file. Retrieve the location and create the file
            String absoluteFilePath = current+SRC_PROJECT+MAIN_CLASS+JAVA_EXTENSION;
            System.out.println(absoluteFilePath);

            File file = new File(absoluteFilePath);
            file.createNewFile();

            // Create Buffer with all the text
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("/*");
            writer.newLine();
            writer.write("This file has been generated "+ new Date());
            writer.newLine();
            writer.write("*/");
            writer.newLine();
            writer.newLine();

            // Get unique list of import
            Set<String> importSet = new HashSet<>();
            for (Map.Entry<String, CodeFile> entry : files.entrySet()) {
                importSet.addAll(entry.getValue().getImports());
            }

            // write all the import into the file
            for(String importLine: importSet){
                writer.write(importLine);
            }
            writer.newLine();
            writer.write("class "+ MAIN_CLASS + " {");
            writer.newLine();

            for (Map.Entry<String, CodeFile> entry : files.entrySet()) {
                writer.write(entry.getValue().getContent());
                writer.newLine();
            }

            writer.write("public static void main(String[] args) { (new "+ MAIN_CLASS + "()).new Main(args); }");
            writer.newLine();
            writer.write("}");
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
