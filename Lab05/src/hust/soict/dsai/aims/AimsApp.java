package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class AimsApp {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCurrentCart();
                case 0 -> System.out.println("Exiting the application...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void updateStore() {
    }


    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        System.out.println("STORE ITEMS:");
        store.printStore();
        storeMenu();
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> seeMediaDetails();
            case 2 -> addMediaToCart();
            case 3 -> playMedia();
            case 4 -> seeCurrentCart();
            case 0 -> System.out.println("Going back to main menu...");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> cart.addMedia(media);
            case 2 -> {
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("This media cannot be played.");
                }
            }
            case 0 -> System.out.println("Going back...");
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to the cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void seeCurrentCart() {
        cart.printCart();
        cartMenu();
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> filterMediasInCart();
            case 2 -> sortMediasInCart();
            case 3 -> removeMediaFromCart();
            case 4 -> playMedia();
            case 5 -> placeOrder();
            case 0 -> System.out.println("Going back to main menu...");
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void filterMediasInCart() {
        System.out.println("Filter medias by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = Integer.parseInt(scanner.nextLine());
        // Implement filtering logic here
    }

    public static void sortMediasInCart() {
        System.out.println("Sort medias by:");
        System.out.println("1. Title then Cost");
        System.out.println("2. Cost then Title");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            cart.sortByTitleCost();
        } else if (choice == 2) {
            cart.sortByCostTitle();
        } else {
            System.out.println("Invalid choice.");
        }
        cart.printCart();
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from the cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully.");
    }
}
