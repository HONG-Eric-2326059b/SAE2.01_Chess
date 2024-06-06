module Chess {
    requires javafx.controls;
    requires javafx.fxml;

    opens Chess to javafx.fxml;
    exports Chess;
    exports Chess.Controllers;
    opens Chess.Controllers to javafx.fxml;
}