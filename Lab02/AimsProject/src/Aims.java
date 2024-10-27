public class Aims {
    public static void main(String[] args) {
        Customer customer = new Customer("Hieu", "hieunt@gmail.com", "Hadong", "Email");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        Cart cart = new Cart();
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        //Add to custommer cart
        customer.addToOrderHistory(cart);

        //Display customer cartt
        customer.displayCustomerInfo();
    }
}
