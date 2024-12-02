package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[20];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("The disc is not in the cart.");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

//    public void addDigitalVideoDisc(hust.soict.dsai.aims.disc.DigitalVideoDisc[] dvdList) {
//        for (hust.soict.dsai.aims.disc.DigitalVideoDisc dvd : dvdList) {
//            addDigitalVideoDisc(dvd);
//        }
//    }

//    public void addDigitalVideoDisc(hust.soict.dsai.aims.disc.DigitalVideoDisc dvd1, hust.soict.dsai.aims.disc.DigitalVideoDisc dvd2) {
//        addDigitalVideoDisc(dvd1);
//        addDigitalVideoDisc(dvd2);
//    }

//    public void printCart() {
//        System.out.println("Ordered Items:");
//        for (int i = 0; i < qtyOrdered; i++) {
//            hust.soict.dsai.aims.disc.DigitalVideoDisc dvd = itemsOrdered[i];
//            System.out.println((i + 1) + ". DVD - " + dvd.getTitle() + " - " + dvd.getCategory() + " - "
//                    + dvd.getDirector() + " - " + dvd.getLength() + " mins: " + dvd.getCost() + " $");
//        }
//        System.out.println("Total cost: " + totalCost() + " $");
//    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.printf("%d. DVD - %s - %s - %s - %d mins: %.2f $\n",
                    i + 1,
                    dvd.getTitle(),
                    dvd.getCategory() != null ? dvd.getCategory() : "Unknown",
                    dvd.getDirector() != null ? dvd.getDirector() : "Unknown",
                    dvd.getLength() > 0 ? dvd.getLength() : 0,
                    dvd.getCost()
            );
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }

    public DigitalVideoDisc searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        return null;
    }

    public DigitalVideoDisc searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                return itemsOrdered[i];
            }
        }
        return null;
    }




    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }
}
