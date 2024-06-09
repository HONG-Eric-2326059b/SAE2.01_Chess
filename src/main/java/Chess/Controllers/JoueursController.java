package Chess.Controllers;

import Chess.ChessMain;
import Chess.Piece.*;
import Chess.Player;
import com.opencsv.exceptions.CsvValidationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.opencsv.CSVReader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    private TableView<Player> TableJoueur;
    @FXML
    private GridPane Plateau;

    private static final ObservableList<Player> ListeJoueur = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //implemente les button du haut
        PageController Pagecontroller = new PageController();
        Pagecontroller.topButton(ButtonN, ButtonJ, ButtonP);
        //creer une colone Nom
        TableColumn<Player, String> NomColumn = new TableColumn<>("Nom");
        NomColumn.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        //creer une colone Prenom
        TableColumn<Player, String> PrenomColumn = new TableColumn<>("Prenom");
        PrenomColumn.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        //creer une colone PartiesJouer
        TableColumn<Player, Integer> PartiesJouerColumn = new TableColumn<>("PartiesJouer");
        PartiesJouerColumn.setCellValueFactory(new PropertyValueFactory<>("PartiesJouer"));
        //creer une colone Parties Gagner
        TableColumn<Player, Integer> PartiesGagnerColumn = new TableColumn<>("PartiesGagner");
        PartiesGagnerColumn.setCellValueFactory(new PropertyValueFactory<>("PartiesGagner"));
        //ajoute les colone dans le tableview
        TableJoueur.getColumns().addAll(NomColumn, PrenomColumn, PartiesJouerColumn, PartiesGagnerColumn);
        //load le csv et le met dans le tableview
        URL resource = getClass().getResource("/Player.csv");
        if (resource != null) {
            File file = new File(resource.getFile());
            loadCsv(file);
            TableJoueur.setItems(ListeJoueur);
        }
        affich();
    }

    //fonction pour load le csv
    public static void loadCsv(File file) {
        ListeJoueur.clear();
        try (CSVReader listeJ = new CSVReader(new FileReader(file))) {
            String[] nextRecord;

            listeJ.readNext();

            while ((nextRecord = listeJ.readNext()) != null) {
                String Nom = nextRecord[0];
                String Prenom = nextRecord[1];
                int PartiesJouer = Integer.parseInt(nextRecord[2].trim());
                int PartiesGagner = Integer.parseInt(nextRecord[3].trim());
                Player player = new Player(Nom, Prenom, PartiesJouer, PartiesGagner);
                ListeJoueur.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
        }
    }
    //affiche les piece
    private void affich(){
        Cavalier wn1 = new Cavalier(new Couleur("WHITE"),1,0, placePiece("b1", "wn.png"));
        Cavalier wn2 = new Cavalier(new Couleur("WHITE"),6,0, placePiece("g1", "wn.png"));
        Tour wt1 = new Tour(new Couleur("WHITE"),0,0, placePiece("a1", "wr.png"));
        Tour wt2 = new Tour(new Couleur("WHITE"),7,0, placePiece("h1", "wr.png"));
        Fou wf1 = new Fou(new Couleur("WHITE"),2,0,placePiece("c1","wb.png"));
        Fou wf2 = new Fou(new Couleur("WHITE"),5,0,placePiece("f1","wb.png"));
        Roi R1 = new Roi(new Couleur("WHITE"),4,0, placePiece("e1", "wk.png"));
        Dame Q1 = new Dame(new Couleur("WHITE"),3,0, placePiece("d1", "wq.png"));
        Pion P1 = new Pion(new Couleur("WHITE"),0,1, placePiece("a2", "wp.png"));
        Pion P2 = new Pion(new Couleur("WHITE"),1,1, placePiece("b2", "wp.png"));
        Pion P3 = new Pion(new Couleur("WHITE"),2,1, placePiece("c2", "wp.png"));
        Pion P4 = new Pion(new Couleur("WHITE"),3,1, placePiece("d2", "wp.png"));
        Pion P5 = new Pion(new Couleur("WHITE"),4,1, placePiece("e2", "wp.png"));
        Pion P6 = new Pion(new Couleur("WHITE"),5,1, placePiece("f2", "wp.png"));
        Pion P7 = new Pion(new Couleur("WHITE"),6,1, placePiece("g2", "wp.png"));
        Pion P8 = new Pion(new Couleur("WHITE"),7,1, placePiece("h2", "wp.png"));


        //Pieces Noirs
        Cavalier bn2 = new Cavalier(new Couleur("BLACK"),6,7, placePiece("g8", "bn.png"));
        Cavalier bn1 = new Cavalier(new Couleur("BLACK"),2,7, placePiece("b8", "bn.png"));
        Tour bt1 = new Tour(new Couleur("BLACK"),0,7, placePiece("a8", "br.png"));
        Tour bt2 = new Tour(new Couleur("BLACK"),7,7, placePiece("h8", "br.png"));
        Fou bf1 = new Fou(new Couleur("BLACK"),2,7,placePiece("c8","bb.png"));
        Fou bf2 = new Fou(new Couleur("BLACK"),5,7,placePiece("f8","bb.png"));
        Roi bR1 = new Roi(new Couleur("BLACK"),4,7, placePiece("e8", "bk.png"));
        Dame bQ1 = new Dame(new Couleur("BLACK"),3,7, placePiece("d8", "bq.png"));
        Pion bP1 = new Pion(new Couleur("BLACK"),0,6, placePiece("a7", "bp.png"));
        Pion bP2 = new Pion(new Couleur("BLACK"),1,6, placePiece("b7", "bp.png"));
        Pion bP3 = new Pion(new Couleur("BLACK"),2,6, placePiece("c7", "bp.png"));
        Pion bP4 = new Pion(new Couleur("BLACK"),3,6, placePiece("d7", "bp.png"));
        Pion bP5 = new Pion(new Couleur("BLACK"),4,6, placePiece("e7", "bp.png"));
        Pion bP6 = new Pion(new Couleur("BLACK"),5,6, placePiece("f7", "bp.png"));
        Pion bP7 = new Pion(new Couleur("BLACK"),6,6, placePiece("g7", "bp.png"));
        Pion bP8 = new Pion(new Couleur("BLACK"),7,6, placePiece("h7", "bp.png"));
    }
    //initialize les image pour les pieces
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
}
