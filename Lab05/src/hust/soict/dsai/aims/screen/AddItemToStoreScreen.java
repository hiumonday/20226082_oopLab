package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected JTextField titleField, costField;

    public AddItemToStoreScreen(Store store, String itemType) {
        this.store = store;

        setTitle("Add " + itemType);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Header
        JLabel lblHeader = new JLabel("Add " + itemType, SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblHeader, BorderLayout.NORTH);

        // Input Fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Title: "));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Cost: "));
        costField = new JTextField();
        inputPanel.add(costField);

        add(inputPanel, BorderLayout.CENTER);

        // Buttons
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> handleAdd());
        add(btnAdd, BorderLayout.SOUTH);

        setVisible(true);
    }

    protected abstract void handleAdd();
}
