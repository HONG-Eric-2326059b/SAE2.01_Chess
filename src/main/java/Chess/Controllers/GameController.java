package Chess.Controllers;

import Chess.ChessMain;
import Chess.Piece.*;
import Chess.Timer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class GameController implements Initializable {
    @FXML
    private Button ButtonJ;
    @FXML
    private Button ButtonN;
    @FXML
    private Button ButtonP;
    @FXML
    private GridPane Plateau;
    @FXML
    private Label TimerBlack;

    @FXML
    private Label TimerBlanc;
    @FXML
    private Label JW1;
    @FXML
    private Label JB1;
    @FXML
    private TextField JW;
    @FXML
    private TextField JB;

    private Timer player1Timer;
    private Timer player2Timer;
    private boolean CoupJouer = true;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        PageController Pagecontroller = new PageController();
        Pagecontroller.topButton(ButtonN,ButtonJ,ButtonP);
        Piece();
        Timer();
        playerMove();
        JW.textProperty().addListener((observable, oldValue, newValue) -> {
            JW1.setText(newValue);
        });
        JB.textProperty().addListener((observable, oldValue, newValue) -> {
            JB1.setText(newValue);
        });
    }
    // Victoire en cas de minuterie == 0
    public void playerMove() {
        if (CoupJouer) {
            player1Timer.stop();
            if (player1Timer.getSecondsRestante() == 0) {
                VictoireDesNoirs();
                System.out.println("Victoire des Blanc");
                return;
            }
            startPlayerTimer(player1Timer, TimerBlack);
        } else {
            player2Timer.stop();
            if (player2Timer.getSecondsRestante() == 0) {
                VictoireDesBlancs();
                System.out.println("Victoire des Noirs");
                return;
            }
            startPlayerTimer(player2Timer, TimerBlanc);
        }
        CoupJouer = !CoupJouer;
    }
    //
    private boolean VictoireDesBlancs() {
        return true;
    }
    private boolean VictoireDesNoirs() {
        return false;
    }
    //Timer des joueurs
    private void Timer(){
        player1Timer = new Timer(180);
        player2Timer = new Timer(180);
        player1Timer.start();

        new Thread(() -> {
            while (player1Timer.Lancement()) {
                updateTimer(TimerBlack, player1Timer);
            }
        }).start();

        // Démarrer la minuterie du joueur 2
        new Thread(() -> {
            try {
                Thread.sleep(100); // Délai avant de démarrer la minuterie du joueur 2
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player2Timer.start();
            while (player2Timer.Lancement()) {
                updateTimer(TimerBlanc, player2Timer);
            }
        }).start();
    }
    //Commence le timer
    private void startPlayerTimer(Timer timer, Label timerLabel) {
        new Thread(() -> {
            while (timer.Lancement()) {
                updateTimer(timerLabel, timer);
            }
        }).start();
    }
    // permet de mettre a jour le timer (du label)
    private void updateTimer(Label label, Timer timer) {
        int secondsLeft = timer.getSecondsRestante();
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        String time = String.format("%02d:%02d", minutes, seconds);

        javafx.application.Platform.runLater(() -> {
            label.setText(time);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // initialize les images pour les pieces
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
    private void Piece() {
        // charge les pièces et les déplacements
        // Piece Blancs
        Cavalier wn1 = new Cavalier(new Couleur("WHITE"),1,0, placePiece("b1", "wn.png"));
        wn1.getImage().setOnMouseClicked(event -> {
            wn1.deplaceCavalier(Plateau);
        });
        Cavalier wn2 = new Cavalier(new Couleur("WHITE"),6,0, placePiece("g1", "wn.png"));
        wn2.getImage().setOnMouseClicked(event -> {
            wn2.deplaceCavalier(Plateau);
        });
        Tour wt1 = new Tour(new Couleur("WHITE"),0,0, placePiece("a1", "wr.png"));
        wt1.getImage().setOnMouseClicked(event -> {
            wt1.deplaceTours(Plateau);
        });
        Tour wt2 = new Tour(new Couleur("WHITE"),7,0, placePiece("h1", "wr.png"));
        wt2.getImage().setOnMouseClicked(event -> {
            wt2.deplaceTours(Plateau);
        });
        Fou wf1 = new Fou(new Couleur("WHITE"),2,0,placePiece("c1","wb.png"));
        wf1.getImage().setOnMouseClicked(event -> {
            wf1.deplaceFou(Plateau);
        });
        Fou wf2 = new Fou(new Couleur("WHITE"),5,0,placePiece("f1","wb.png"));
        wf2.getImage().setOnMouseClicked(event -> {
            wf2.deplaceFou(Plateau);
        });
        Roi R1 = new Roi(new Couleur("WHITE"),4,0, placePiece("e1", "wk.png"));
        R1.getImage().setOnMouseClicked(event ->{
            R1.deplaceRoi(Plateau);
        });
        Dame Q1 = new Dame(new Couleur("WHITE"),3,0, placePiece("d1", "wq.png"));
        Q1.getImage().setOnMouseClicked(event -> {
            Q1.deplaceDame(Plateau);
        });
        Pion wp1 = new Pion(new Couleur("WHITE"),0,1, placePiece("a2", "wp.png"));
        wp1.getImage().setOnMouseClicked(event -> {
            wp1.deplacePion(Plateau);
        });
        Pion wp2 = new Pion(new Couleur("WHITE"),1,1, placePiece("b2", "wp.png"));
        wp2.getImage().setOnMouseClicked(event -> {
            wp2.deplacePion(Plateau);
        });
        Pion wp3 = new Pion(new Couleur("WHITE"),2,1, placePiece("c2", "wp.png"));
        wp3.getImage().setOnMouseClicked(event -> {
            wp3.deplacePion(Plateau);
        });
        Pion wp4 = new Pion(new Couleur("WHITE"),3,1, placePiece("d2", "wp.png"));
        wp4.getImage().setOnMouseClicked(event -> {
            wp4.deplacePion(Plateau);
        });
        Pion wp5 = new Pion(new Couleur("WHITE"),4,1, placePiece("e2", "wp.png"));
        wp5.getImage().setOnMouseClicked(event -> {
            wp5.deplacePion(Plateau);
        });
        Pion wp6 = new Pion(new Couleur("WHITE"),5,1, placePiece("f2", "wp.png"));
        wp6.getImage().setOnMouseClicked(event -> {
            wp6.deplacePion(Plateau);
        });
        Pion wp7 = new Pion(new Couleur("WHITE"),6,1, placePiece("g2", "wp.png"));
        wp7.getImage().setOnMouseClicked(event -> {
            wp7.deplacePion(Plateau);
        });
        Pion wp8 = new Pion(new Couleur("WHITE"),7,1, placePiece("h2", "wp.png"));
        wp8.getImage().setOnMouseClicked(event -> {
            wp8.deplacePion(Plateau);
        });

        // Piece Noirs
        Cavalier bn1 = new Cavalier(new Couleur("BLACK"), 1, 7, placePiece("b8", "bn.png"));
        bn1.getImage().setOnMouseClicked(event -> {
            bn1.deplaceCavalier(Plateau);
        });

        Cavalier bn2 = new Cavalier(new Couleur("BLACK"), 6, 7, placePiece("g8", "bn.png"));
        bn2.getImage().setOnMouseClicked(event -> {
            bn2.deplaceCavalier(Plateau);
        });

        Tour bt1 = new Tour(new Couleur("BLACK"), 0, 7, placePiece("a8", "br.png"));
        bt1.getImage().setOnMouseClicked(event -> {
            bt1.deplaceTours(Plateau);
        });
        Tour bt2 = new Tour(new Couleur("BLACK"), 7, 7, placePiece("h8", "br.png"));
        bt2.getImage().setOnMouseClicked(event -> {
            bt2.deplaceTours(Plateau);
        });
        Fou bf1 = new Fou(new Couleur("BLACK"), 2, 7, placePiece("c8", "bb.png"));
        bf1.getImage().setOnMouseClicked(event -> {
            bf1.deplaceFou(Plateau);
        });
        Fou bf2 = new Fou(new Couleur("BLACK"), 5, 7, placePiece("f8", "bb.png"));
        bf2.getImage().setOnMouseClicked(event -> {
            bf2.deplaceFou(Plateau);
        });
        Roi r1 = new Roi(new Couleur("BLACK"), 4, 7, placePiece("e8", "bk.png"));
        r1.getImage().setOnMouseClicked(event -> {
            r1.deplaceRoi(Plateau);
        });
        Dame q1 = new Dame(new Couleur("BLACK"), 3, 7, placePiece("d8", "bq.png"));
        q1.getImage().setOnMouseClicked(event -> {
            q1.deplaceDame(Plateau);
        });
        Pion bp1 = new Pion(new Couleur("BLACK"), 0, 6, placePiece("a7", "bp.png"));
        bp1.getImage().setOnMouseClicked(event -> {
            bp1.deplacePion(Plateau);
        });
        Pion bp2 = new Pion(new Couleur("BLACK"), 1, 6, placePiece("b7", "bp.png"));
        bp2.getImage().setOnMouseClicked(event -> {
            bp2.deplacePion(Plateau);
        });
        Pion bp3 = new Pion(new Couleur("BLACK"), 2, 6, placePiece("c7", "bp.png"));
        bp3.getImage().setOnMouseClicked(event -> {
            bp3.deplacePion(Plateau);
        });
        Pion bp4 = new Pion(new Couleur("BLACK"), 3, 6, placePiece("d7", "bp.png"));
        bp4.getImage().setOnMouseClicked(event -> {
            bp4.deplacePion(Plateau);
        });
        Pion bp5 = new Pion(new Couleur("BLACK"), 4, 6, placePiece("e7", "bp.png"));
        bp5.getImage().setOnMouseClicked(event -> {
            bp5.deplacePion(Plateau);
        });
        Pion bp6 = new Pion(new Couleur("BLACK"), 5, 6, placePiece("f7", "bp.png"));
        bp6.getImage().setOnMouseClicked(event -> {
            bp6.deplacePion(Plateau);
        });
        Pion bp7 = new Pion(new Couleur("BLACK"), 6, 6, placePiece("g7", "bp.png"));
        bp7.getImage().setOnMouseClicked(event -> {
            bp7.deplacePion(Plateau);
        });
        Pion bp8 = new Pion(new Couleur("BLACK"), 7, 6, placePiece("h7", "bp.png"));
        bp8.getImage().setOnMouseClicked(event -> {
            bp8.deplacePion(Plateau);
        });
    }
}
