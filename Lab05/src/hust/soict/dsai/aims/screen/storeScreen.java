package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class storeScreen extends JFrame{
    private Store store;
    private Cart cart;

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookToStoreScreen(store));

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store));

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View store");
        menu.add(viewStore);

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> new CartScreen(cart));
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }


    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart); // Pass cart here
            center.add(cell);
        }

        return center;
    }


    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open CartScreen when the button is clicked
                new CartScreen(storeScreen.this.cart);
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }


    public storeScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AIMS Store");
        setSize(1024, 768);
        setVisible(true);
    }

    private void refreshCenterPanel() {
        // Remove the old center panel
        getContentPane().remove(1); // Assumes center panel is at index 1
        // Recreate the center panel with updated store contents
        JPanel centerPanel = createCenter();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        // Revalidate and repaint to apply changes
        revalidate();
        repaint();
    }

    public class MediaStore extends JPanel {
        private Media media;
        private Cart cart; // Add Cart reference

        public MediaStore(Media media, Cart cart) { // Update constructor to accept Cart
            this.media = media;
            this.cart = cart;

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // Title label
            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);

            // Cost label
            JLabel cost = new JLabel(media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            // Container for buttons
            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            // Add to cart button
            JButton btnAddToCart = new JButton("Add to cart");
            btnAddToCart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cart.addMedia(media); // Add media to cart
                    System.out.println("Added to cart: " + media.getTitle());
                }
            });
            container.add(btnAddToCart);

            // Add "Play" button if the media is playable
            if (media instanceof Playable) {
                JButton btnPlay = new JButton("Play");
                btnPlay.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog playDialog = new JDialog();
                        playDialog.setTitle("Playing Media");
                        playDialog.setSize(300, 100);
                        playDialog.add(new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER));
                        playDialog.setLocationRelativeTo(null);
                        playDialog.setVisible(true);
                    }
                });
                container.add(btnPlay);
            }

            // Add components to the MediaStore panel
            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            // Add a border around each media item
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }



    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Add some media to the store for testing
        store.addMedia(new Book(1, "Effective Java", "Programming", 45.99f));
        store.addMedia(new DigitalVideoDisc("The Godfather", "Drama", 15.99f));


        new storeScreen(store, cart);
    }
}

