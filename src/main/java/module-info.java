module Chess {
    requires javafx.controls;
    requires javafx.fxml;

    opens Chess to javafx.fxml;
    exports Chess;
}