package Lab2.repository;

import java.util.List;

public interface BookRepository {

    List<String> readSentence(String fileName);

    List<String> readWords(String fileName);
}
