package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();
        List<String> strings;
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }
        String[] linesFromFile = strings.toArray(new String[0]);
        for (String line: linesFromFile) {
            for (String splitedLine : line.split(SEPARATOR)) {
                if (splitedLine.toLowerCase().charAt(0) == SPECIFIED_CHARACTER) {
                    result.add(splitedLine.toLowerCase().replaceAll("[.,!?]", ""));
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
