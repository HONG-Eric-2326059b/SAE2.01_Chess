package Chess;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessMain extends Application {
    @FXML
    private GridPane Plateau;
    private final int tailleCase = 75;

    private static Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Chess.fxml"));
        scene = new Scene(loader.load());
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

//Test affichage des piece
private void AffichePlateau() {
        Plateau.getChildren().clear();
        //Piece Blanche
        TypePiece("a1", "wr.png");
        TypePiece("b1", "wn.png");
        TypePiece("c1", "wb.png");
        TypePiece("d1", "wq.png");
        TypePiece("e1", "wk.png");
        TypePiece("f1", "wb.png");
        TypePiece("g1", "wn.png");
        TypePiece("h1", "wr.png");
        //Pion Blanc
        for (char c = 'a'; c <= 'h'; c++) {
            TypePiece(c + "2", "wp.png");
        }
        // Piece noir
        TypePiece("a8", "br.png");
        TypePiece("b8", "bn.png");
        TypePiece("c8", "bb.png");
        TypePiece("d8", "bq.png");
        TypePiece("e8", "bk.png");
        TypePiece("f8", "bb.png");
        TypePiece("g8", "bn.png");
        TypePiece("h8", "br.png");
        //Pion Noir
        for (char c = 'a'; c <= 'h'; c++) {
            TypePiece(c + "7", "bp.png");
        }
    }
    //Charger les images des piece et la place dans des cases/coordonnees
    private void TypePiece(String position, String imagePiece) {
        Image Piece = new Image(getClass().getResourceAsStream("/image/" + imagePiece));
        ImageView imageView = new ImageView(Piece);
        imageView.setFitHeight(tailleCase);
        imageView.setFitWidth(tailleCase);

        int column = position.charAt(0) - 'a';
        int row = 8 - Character.getNumericValue(position.charAt(1));
        Plateau.add(imageView, column, row);
    }

    public static void main(String[] args) {
        launch();
    }
}
