package Chess;

import Chess.Piece.Tour;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Chess.Player;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChessMain extends Application {
    @FXML
    private GridPane Plateau;
    public static final int tailleCase = 75;

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
    TypePiece("11", "wr.png");
    TypePiece("21", "wn.png");
    TypePiece("31", "wb.png");
    TypePiece("41", "wq.png");
    TypePiece("51", "wk.png");
    TypePiece("61", "wb.png");
    TypePiece("71", "wn.png");
    TypePiece("81", "wr.png");
    //Pion Blanc
    for (char c = '1'; c <= '8'; c++) {
        TypePiece(c + "2", "wp.png");
    }
    // Piece noir
    TypePiece("18", "br.png");
    TypePiece("28", "bn.png");
    TypePiece("38", "bb.png");
    TypePiece("48", "bq.png");
    TypePiece("58", "bk.png");
    TypePiece("68", "bb.png");
    TypePiece("78", "bn.png");
    TypePiece("88", "br.png");
    //Pion Noir
    for (char c = '1'; c <= '8'; c++) {
        TypePiece(c + "7", "bp.png");
    }
}
    //Charger les images des piece et la place dans des cases/coordonnees
    private void TypePiece(String position, String imagePiece) {
        Image Piece = new Image(getClass().getResourceAsStream("/image/" + imagePiece));
        ImageView imageView = new ImageView(Piece);
        imageView.setFitHeight(tailleCase);
        imageView.setFitWidth(tailleCase);


        int column = 8 - Character.getNumericValue(position.charAt(1));
        int row = 8 - Character.getNumericValue(position.charAt(1));
        Plateau.add(imageView, column, row);
    }

    public static void main(String[] args) {
        launch();
    }
}
