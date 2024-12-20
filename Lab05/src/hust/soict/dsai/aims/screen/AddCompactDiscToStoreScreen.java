package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "CD");
    }

    @Override
    protected void handleAdd() {
        try {
            String title = titleField.getText();
            float cost = Float.parseFloat(costField.getText());

            CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, "CD Category", cost);
            store.addMedia(cd);

            JOptionPane.showMessageDialog(this, "CD added successfully!");
            SwingUtilities.invokeLater(() -> new storeScreen(store, cart));
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
        }
    }
}
