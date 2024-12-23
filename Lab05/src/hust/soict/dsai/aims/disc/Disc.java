package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String cdCategory, float cost) {
        super(id, title, cdCategory, cost);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
