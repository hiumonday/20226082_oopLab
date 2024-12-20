package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "DVD");
    }

    @Override
    protected void handleAdd() {
        try {
            String title = titleField.getText();
            float cost = Float.parseFloat(costField.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, "DVD Category", cost);
            store.addMedia(dvd);

            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            SwingUtilities.invokeLater(() -> new storeScreen(store, cart));
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
        }
    }
}
