package Lab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {

    public static List<String> read(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;
        List<String> sentences = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] cells = line.split("[.!?]\\s*");
            Collections.addAll(sentences, cells);
        }
        br.close();
        return sentences;
    }
}
