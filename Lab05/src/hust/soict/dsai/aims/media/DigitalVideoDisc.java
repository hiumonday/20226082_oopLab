package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.disc.Disc;

public class DigitalVideoDisc extends Disc implements Playable {

    private String director;
    private int length;

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0, null, 0); // Use default values for other fields
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
        this.director = director;
        this.length = length;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, null, 0);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, null, 0);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, null, 0);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minutes");
    }

    @Override
    public String toString() {
        return "DVD [ID=" + getId() + ", Title=" + getTitle() + ", Category=" + getCategory() +
                ", Cost=" + getCost() + ", Director=" + getDirector() + ", Length=" + getLength() + "]";
    }


}
