package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap: dvd1 title = " + dvd1.getTitle() + ", dvd2 title = " + dvd2.getTitle());
        swap(dvd1, dvd2);
        System.out.println("After swap: dvd1 title = " + dvd1.getTitle() + ", dvd2 title = " + dvd2.getTitle());

        changeTitle(dvd1, "New Jungle");
        System.out.println("After changeTitle: dvd1 title = " + dvd1.getTitle());
    }

    public static void changeTitle(DigitalVideoDisc dvd, String newTitle) {
        dvd.setTitle(newTitle);
        System.out.println("Inside changeTitle: dvd title = " + dvd.getTitle());
    }


    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc temp = o1;
        o1 = o2;
        o2 = temp;
        System.out.println("Inside swap: o1 title = " + o1.getTitle() + ", o2 title = " + o2.getTitle());
    }
}
