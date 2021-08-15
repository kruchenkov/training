package Lab2.repository;

import java.awt.print.Book;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BookRepositoryImpl implements BookRepository{
    public BookRepositoryImpl(){}

    public BookRepositoryImpl(String fileName, char letter){
        List<String> sentences = readWords(fileName);
        Map<String, Integer> sortedWords = mapWords(sentences, letter);
        sortedWords = sortWords(sortedWords);

        for (Map.Entry entry : sortedWords.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }

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

    public Map<String, Integer> mapWords(List<String> words, char inputLetter) {
        Map<String, Integer> sortedWords = new HashMap<>();
        Iterator<String> iterator = words.iterator();
        String w = String.valueOf(inputLetter);
        while (iterator.hasNext()) {
            int countLetters = 0;
            String word = iterator.next();
            if (word.toLowerCase().contains(w)) {
                for (char letter : word.toCharArray()) {
                    if (String.valueOf(letter).equals(w)) {
                        countLetters++;
                    }
                }
                sortedWords.put(word, countLetters);
            }
        }
        return sortedWords;
    }

    public Map<String, Integer> sortWords(Map<String, Integer> words) {
        Map<String, Integer> sort = new LinkedHashMap<>();
        List<String> list;
        for (int i = Collections.max(words.values()); i > 0; i--) {
            list = new LinkedList<>();
            for (Map.Entry<String, Integer> entry : words.entrySet()) {
                if (entry.getValue().equals(i)) {
                    list.add(entry.getKey());
                }
            }
            Collections.sort(list);
            for (String s : list) {
                sort.put(s, i);
            }
        }
        return sort;
    }

}
