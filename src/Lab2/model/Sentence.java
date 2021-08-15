package Lab2.model;

import Lab2.repository.BookRepositoryImpl;

import java.util.List;

public class Sentence {
    BookRepositoryImpl bookRepositoryImpl = new BookRepositoryImpl();

    private List<String> sentences = bookRepositoryImpl.readSentence("Book.txt");

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }
}
