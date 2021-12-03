package com.codinggame.utils.amadeus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CodeFile {

    private String path;
    private Set<String> imports = new HashSet<String>();
    private String filePackage;
    private String content;

    public CodeFile(String path) {
        this.path = path;


        String[] fileSplit = path.split("/");
        String fileName = fileSplit[fileSplit.length - 1];

        int lineNumber = 0;
        System.out.println("reading " + path);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.startsWith("package ")) {
                    this.filePackage = line.substring(8, line.length() - 1);
                } else if (line.startsWith("import ")) {
                    this.imports.add(line);
                } else if (line.trim().length() > 0) {
                    if (line.startsWith("public final class")) {
                        line = line.replace("public final class", "final class");
                    } else if (line.startsWith("public class")) {
                        line = line.replace("public class", "class");
                    } else if (line.startsWith("public abstract class")) {
                        line = line.replace("public abstract class", "abstract class");
                    } else if (line.startsWith("public interface")) {
                        line = line.replace("public interface", "interface");
                    } else if (line.startsWith("public enum")) {
                        line = line.replace("public enum", "enum");
                    }
                    builder.append(line);
                   // builder.append("  // " + fileName + ", " + lineNumber);
                    builder.append("\n");
                }
            }
            this.content = builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<String> getImports() {
        return imports;
    }

    public String getContent() {
        return content;
    }
}
