package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        cart.printCart();

        int searchId = dvd2.getId();
        Media foundById = cart.searchById(searchId);
        if (foundById != null) {
            System.out.println("Search by ID " + searchId + ": " + foundById.getTitle());
        } else {
            System.out.println("No DVD found with ID " + searchId);
        }

        String searchTitle = "The Lion King";
        Media foundByTitle = cart.searchByTitle(searchTitle);
        if (foundByTitle != null) {
            System.out.println("Search by Title \"" + searchTitle + "\": " + foundByTitle.getTitle());
        } else {
            System.out.println("No DVD found with Title \"" + searchTitle + "\"");
        }
    }
}
