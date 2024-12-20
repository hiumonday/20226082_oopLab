package hust.soict.dsai.javafx;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class CartScreenController {
    private Cart cart; // Cart object passed to the controller


    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    private ObservableList<Media> mediaList = FXCollections.observableArrayList();
    private FilteredList<Media> filteredList;

    @FXML
    private void initialize() {


        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));


        filteredList = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);


        tblMedia.setItems(filteredList);


        btnPlay.setVisible(false);
        btnRemove.setVisible(false);


        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });

        // Listener for filter input
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
        // Update total cost dynamically
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
            Platform.runLater(() -> updateTotalCost());
        });

        updateTotalCost();
    }



    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        float total = 0;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        lblTotalCost.setText(String.format("%.2f$", total));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {

        Media media = tblMedia.getSelectionModel().getSelectedItem();


        if (media != null) {
            this.cart.removeMedia(media);
            System.out.println("Removed media: " + media.getTitle());
        }
    }

    private void showFilteredMedia(String filterText) {
        filteredList.setPredicate(media -> {
            // If filter text is empty, display all items
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filterText.toLowerCase();


            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(filterText);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }

            return true;
        });
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");


        alert.showAndWait();


        this.cart.clear();
        updateTotalCost();
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Playing Media");
        alert.setHeaderText(null);
        alert.setContentText("Playing media");


        alert.showAndWait();
    }

}
