package hust.soict.dsai.aims.cart;

import java.util.Collections;
import hust.soict.dsai.aims.media.Media;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // Method to add a Media object to the cart
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The item has been added.");
        } else {
            System.out.println("The item is already in the cart.");
        }
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    // Method to remove a Media object from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The item has been removed.");
        } else {
            System.out.println("The item is not in the cart.");
        }
    }

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Method to print the contents of the cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.printf("%d. %s - %s - %.2f $\n",
                    i + 1,
                    media.getTitle(),
                    media.getCategory() != null ? media.getCategory() : "Unknown",
                    media.getCost());
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }

    // Method to search for Media by title
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Method to search for Media by ID
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public void clear() {
        itemsOrdered.clear(); // Clears all items in the ObservableList
        System.out.println("Cart has been cleared.");
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
