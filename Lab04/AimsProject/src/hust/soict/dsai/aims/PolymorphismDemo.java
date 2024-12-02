package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        List<Media> mediaList = new ArrayList<>();

        // Add a Book to the list
        Book book = new Book(1, "Effective Java", "Programming", 45.99f);
        book.addAuthor("Joshua Bloch");
        mediaList.add(book);

        // Add a DigitalVideoDisc to the list
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "The Matrix", "Science Fiction", 19.99f, "The Wachowskis", 136);
        mediaList.add(dvd);

        // Add a CompactDisc to the list
        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 15.99f, "Various Artists", "Queen");
        cd.addTrack(new Track("Bohemian Rhapsody", 354));
        cd.addTrack(new Track("Another One Bites the Dust", 215));
        mediaList.add(cd);

        // Iterate through the list and print using toString()
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
