package Chess.Controllers;

import Chess.ChessMain;
import Chess.Piece.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GameController implements Initializable {
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
        Cavalier bn2 = new Cavalier(new Couleur("BLACK"),6,7, placePiece("g8", "bn.png"));
        bn2.getImage().setOnMouseClicked(event -> {
            bn2.deplaceCavalier(Plateau);
        });

        Cavalier bn1 = new Cavalier(new Couleur("BLACK"),1,7, placePiece("b8", "bn.png"));
        bn1.getImage().setOnMouseClicked(event -> {
            bn1.deplaceCavalier(Plateau);
        });
        Tour wt1 = new Tour(new Couleur("WHITE"),0,0, placePiece("a1", "wr.png"));
        wt1.getImage().setOnMouseClicked(event -> {
            wt1.deplaceTours(Plateau);
        });
        Fou wf1 = new Fou(new Couleur("WHITE"),2,0,placePiece("c1","wb.png"));
        wf1.getImage().setOnMouseClicked(event -> {
            wf1.deplaceFou(Plateau);
        });
        Pion P1 = new Pion(new Couleur("WHITE"),0,1, placePiece("a2", "wp.png"));
        P1.getImage().setOnMouseClicked(event -> {
            P1.deplacePion(Plateau);
        });
        Roi R1 = new Roi(new Couleur("WHITE"),4,0, placePiece("e1", "wk.png"));
        R1.getImage().setOnMouseClicked(event ->{
            R1.deplaceRoi(Plateau);
        });
        Dame Q1 = new Dame(new Couleur("WHITE"),3,0, placePiece("d1", "wq.png"));
        Q1.getImage().setOnMouseClicked(event -> {
            Q1.deplaceDame(Plateau);
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
