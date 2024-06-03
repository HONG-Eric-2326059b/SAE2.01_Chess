module src.main.java {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens src.main.java to javafx.fxml;
    exports src.main.java;
}