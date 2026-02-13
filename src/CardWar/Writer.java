package CardWar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private String fileName;
    private StringBuilder content;

    public Writer(String fileName) {
        this.fileName = fileName;
        this.content = new StringBuilder();
    }

    public void addLine(String line) {
        System.out.println(line);
        content.append(line).append(System.lineSeparator());
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}