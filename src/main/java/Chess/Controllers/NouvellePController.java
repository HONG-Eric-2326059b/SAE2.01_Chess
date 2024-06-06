package Chess.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NouvellePController implements Initializable {
    @FXML
    private Button ButtonJ;
    @FXML
    private Button ButtonN;
    @FXML
    private Button ButtonP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PageController Pagecontroller = new PageController();
        Pagecontroller.topButton(ButtonN,ButtonJ,ButtonP);
    }
}
