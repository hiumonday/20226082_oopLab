package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    // Attribute: Array to store DVDs
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[50]; // Capacity of 50 DVDs
    private int qtyInStore = 0; // Number of DVDs currently in the store

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Method to remove a DVD from the store
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                // Shift remaining DVDs
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Clear the last slot
                qtyInStore--;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                return;
            }
        }
        System.out.println("The DVD \"" + dvd.getTitle() + "\" is not found in the store.");
    }

    // Method to print all DVDs in the store
    public void printStore() {
        System.out.println("***********************STORE***********************");
        if (qtyInStore == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                DigitalVideoDisc dvd = itemsInStore[i];
                System.out.printf("%d. DVD - %s - %s - %s - %d mins: %.2f $\n",
                        i + 1,
                        dvd.getTitle(),
                        dvd.getCategory() != null ? dvd.getCategory() : "Unknown",
                        dvd.getDirector() != null ? dvd.getDirector() : "Unknown",
                        dvd.getLength() > 0 ? dvd.getLength() : 0,
                        dvd.getCost()
                );
            }
        }
        System.out.println("***************************************************");
    }
}
