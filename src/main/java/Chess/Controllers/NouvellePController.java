package Chess.Controllers;

import Chess.ChessMain;
import Chess.Piece.Cavalier;
import Chess.Piece.Couleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class NouvellePController implements Initializable {
    @FXML
    private Button ButtonJouer;
    @FXML
    private Button ButtonJ;
    @FXML
    private Button ButtonN;
    @FXML
    private Button ButtonP;
    @FXML
    private GridPane Plateau;
    private Map<Shape, String> posPossibles = new HashMap<>();


    @Override
    //initialize la page Principale
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PageController Pagecontroller = new PageController();
        Pagecontroller.topButton(ButtonN,ButtonJ,ButtonP);
        // charge les pièces et les déplacements
        Cavalier wn1 = new Cavalier(new Couleur("WHITE"),1,0, placePiece("b1", "wn.png"));
        wn1.getImage().setOnMouseClicked(event -> {
            wn1.deplaceCavalier(Plateau);
        });
        Cavalier wn2 = new Cavalier(new Couleur("WHITE"),6,0, placePiece("g1", "wn.png"));
        wn2.getImage().setOnMouseClicked(event -> {
            wn2.deplaceCavalier(Plateau);
        });
    }
    private ImageView placePiece(String position, String imagePiece) {
        Image Piece = new Image(getClass().getResourceAsStream("/image/" + imagePiece));
        ImageView imageView = new ImageView(Piece);
        imageView.setFitHeight(ChessMain.tailleCase);
        imageView.setFitWidth(ChessMain.tailleCase);

        int colonne = position.charAt(0) - 'a';
        int ligne = 8 - Character.getNumericValue(position.charAt(1));
        Plateau.add(imageView, colonne, ligne);
        return imageView;
    }

    public static void deplacePiece(String nouvellePos, ImageView piece, GridPane plateau){
        int colonne = nouvellePos.charAt(0) - 'a';
        int ligne = 8-Character.getNumericValue(nouvellePos.charAt(1));
        //déplace la pièce dans le GridPane
        plateau.getChildren().remove(piece);
        plateau.add(piece,colonne,ligne);
    }
}
