module Lab {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    opens hust.soict.dsai.javafx to javafx.fxml;
    exports hust.soict.dsai.javafx;

    opens hust.soict.dsai.aims.media to javafx.base;
    opens hust.soict.dsai.aims.screen to javafx.fxml;

    exports hust.soict.dsai.aims.media;
    exports hust.soict.dsai.aims.screen;
}