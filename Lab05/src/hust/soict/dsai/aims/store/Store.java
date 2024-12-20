package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    // Attribute: ArrayList to store Media items
    private ArrayList<Media> itemsInStore = new ArrayList<>(); // Flexible size

    // Method to add a Media item to the store
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void setItemsInStore(ArrayList<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
    }

    // Method to remove a Media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" is not found in the store.");
        }
    }

    // Method to print all Media items in the store
    public void printStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            int index = 1;
            for (Media media : itemsInStore) {
                System.out.printf("%d. %s - %s - %.2f $\n",
                        index++,
                        media.getTitle(),
                        media.getCategory() != null ? media.getCategory() : "Unknown",
                        media.getCost()
                );
            }
        }
        System.out.println("***************************************************");
    }
}
