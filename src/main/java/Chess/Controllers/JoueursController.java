package Chess.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class JoueursController implements Initializable {
    @FXML
    private Button ButtonJ;
    @FXML
    private Button ButtonN;
    @FXML
    private Button ButtonP;
    @FXML
    private Button ButtonJouer;

    @Override
    //initialize la page Joueurs
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PageController Pagecontroller = new PageController();
        Pagecontroller.topButton(ButtonN,ButtonJ,ButtonP);
    }
}
