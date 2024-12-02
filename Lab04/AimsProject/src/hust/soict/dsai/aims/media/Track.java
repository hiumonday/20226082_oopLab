package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.interfaces.Playable;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " seconds");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if the objects are the same instance
        if (obj == null || getClass() != obj.getClass()) return false; // Check class compatibility

        Track track = (Track) obj;
        return length == track.length && title != null && title.equalsIgnoreCase(track.title); // Compare title and length
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.toLowerCase().hashCode() : 0;
        result = 31 * result + length; // Combine hash codes of title and length
        return result;
    }
}
