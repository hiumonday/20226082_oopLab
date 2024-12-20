package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.disc.Disc;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private final List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String cdCategory, float cost) {
        super(id, title,cdCategory,cost);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists: " + track.getTitle());
        } else {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        }
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
