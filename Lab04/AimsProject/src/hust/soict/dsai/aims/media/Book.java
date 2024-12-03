package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private final List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
            authors.add(authorName);
            System.out.println("Author added: " + authorName);
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed: " + authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }

    public String toString() {
        return "Book{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", category='" + super.getCategory() + '\'' +
                ", cost=" + super.getCost() +
                ", authors=" + authors +
                '}';
    }

}
