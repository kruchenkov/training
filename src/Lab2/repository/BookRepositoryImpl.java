package Lab2.repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BookRepositoryImpl implements BookRepository{
    FileInputStream fis = null;

    public List<String> readSentence(String fileName) {

        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;
        List<String> sentences = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                String[] cells = line.toLowerCase().split("[.!?]\\s*");
                sentences.addAll(Arrays.asList(cells));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }

    public List<String> readWords(String fileName) {
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;
        List<String> words = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                String[] cells = line.toLowerCase().split("[.!?]\\s*");
                String word[][] = new String[cells.length][];
                for (int i = 0; i < cells.length; ++i) {
                    word[i] = cells[i].split("[\\p{Punct}\\s]+");
                }
                for (String[] s : word) {
                    words.addAll(Arrays.asList(s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }



}
