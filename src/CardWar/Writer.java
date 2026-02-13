package CardWar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {//variables for the file writer
    private String fileName;
    private StringBuilder content;

    public Writer(String fileName) {//method for creating the file writer
        this.fileName = fileName;
        this.content = new StringBuilder();
    }

    public void addLine(String line) { //write to the file
        System.out.println(line);
        content.append(line).append(System.lineSeparator());
    }

    public void save() { //saves the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}