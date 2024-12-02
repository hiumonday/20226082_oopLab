package hust.soict.dsai.aims;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();


        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Animation", "Frozen", 19.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("James Cameron", "Action", "Avatar", 24.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Sci-Fi", "Star Wars", 20.00f);

        // Display information

        System.out.println("DVD 2: " + dvd2.getTitle() + ", ID: " + dvd2.getId());
        System.out.println("DVD 3: " + dvd3.getTitle() + ", ID: " + dvd3.getId());
        System.out.println("DVD 4: " + dvd4.getTitle() + ", ID: " + dvd4.getId());
        // Display total number of DVDs created
        System.out.println("Total DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());


//        // Test adding a single DVD
//        cart.addDigitalVideoDisc(dvd1);
//
//        // Test adding two DVDs
//        cart.addDigitalVideoDisc(dvd2, dvd3);
//
//        // Test adding an array of DVDs
//        hust.soict.dsai.aims.media.DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4};
//        cart.addDigitalVideoDisc(dvdList);
//
//        // Print total cost to verify
//        System.out.println("Total cost is: " + cart.totalCost());
//
//        // Print all DVDs in the cart
//        cart.printCart();


//        cart.addDigitalVideoDisc(dvd1);
//        cart.addDigitalVideoDisc(dvd2);
//        cart.addDigitalVideoDisc(dvd3);
//
//        cart.removeDigitalVideoDisc(dvd2);
//
//        System.out.println("Total cost is: " + cart.totalCost());
    }
}