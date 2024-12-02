package hust.soict.dsai.aims.media;


import hust.soict.dsai.aims.interfaces.Playable;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private String director;
    private int length;
    private final List<Track> tracks = new ArrayList<>();


    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director, 0);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void addTrack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of tracks: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String title;
        int l;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the title: ");
            title = scanner.nextLine();
            System.out.print("Enter the lenght: ");
            l = scanner.nextInt();
            scanner.nextLine();
            Track track = new Track(title,l);
            addTrack(track);
            this.length = this.length + l;
        }
    }
    public void addTrack(Track track) {
        for (Track i : tracks) {
            if (i.getTitle().equals(track.getTitle())) {
                System.out.println("Track already exists");
                System.out.println(i.getTitle());
                return;
            }
        }
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.artist);
        System.out.println("CD contains " + tracks.size() + " tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD [ID=" + getId() + ", Title=" + getTitle() + ", Category=" + getCategory() +
                ", Cost=" + getCost() + ", Artist=" + artist + ", Length=" + getLength() +
                ", Tracks=" + tracks + "]";
    }

}
