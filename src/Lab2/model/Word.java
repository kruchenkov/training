package Lab2.model;

import Lab2.repository.BookRepositoryImpl;

import java.util.List;

public class Word {
    BookRepositoryImpl bookRepositoryImpl = new BookRepositoryImpl();

    List<String> words = bookRepositoryImpl.readWords("Book.txt");

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
