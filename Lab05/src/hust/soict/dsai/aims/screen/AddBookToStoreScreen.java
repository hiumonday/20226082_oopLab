package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store, "Book");
    }

    @Override
    protected void handleAdd() {
        try {
            String title = titleField.getText();
            float cost = Float.parseFloat(costField.getText());

            Book book = new Book(store.getItemsInStore().size() + 1, title, "Book Category", cost);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added successfully!");
            SwingUtilities.invokeLater(() -> new storeScreen(store, cart));
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
        }
    }
}
