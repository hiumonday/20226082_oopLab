import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String address;
    private String preferredContactMethod;
    private int loyaltyPoints;
    private List<Cart> orderHistory;

    public Customer(String name, String email, String address, String preferredContactMethod) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.address = address;
        this.preferredContactMethod = preferredContactMethod;
        this.loyaltyPoints = 0;
        this.orderHistory = new ArrayList<>();
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addToOrderHistory(Cart cart) {
        orderHistory.add(cart);
        int pointsToAdd = cart.getNumberOfItems();  // 1 point / 1 DVD
        loyaltyPoints += pointsToAdd;
        System.out.println("Added " + pointsToAdd + " loyalty points. Total loyalty points: " + loyaltyPoints);
    }

    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Preferred Contact: " + preferredContactMethod);
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }
}
