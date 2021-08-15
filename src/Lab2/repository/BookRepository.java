package Lab2.repository;

import java.util.List;
import java.util.Map;

public interface BookRepository {

    List<String> readSentence(String fileName);

    List<String> readWords(String fileName);

    Map<String, Integer> mapWords(List<String> words, String inputLetter);
}
