module Chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires java.desktop;

    opens Chess to javafx.fxml;
    exports Chess;
    exports Chess.Controllers;
    opens Chess.Controllers to javafx.fxml;
}