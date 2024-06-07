package Chess.Controllers;

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
    private Button ButtonJouer;
    @FXML
    private TableView<Player> TableJoueur;

    private static final ObservableList<Player> ListeJoueur = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PageController Pagecontroller = new PageController();
        Pagecontroller.topButton(ButtonN, ButtonJ, ButtonP);

        TableColumn<Player, String> nomColumn = new TableColumn<>("Nom");
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("C1"));

        TableColumn<Player, Integer> eloColumn = new TableColumn<>("Elo");
        eloColumn.setCellValueFactory(new PropertyValueFactory<>("C2"));

        TableJoueur.getColumns().addAll(nomColumn, eloColumn);

        String filePath = "Player.csv";
        File file = new File(filePath);

        if (file.exists()) {
            loadCsv(file);
            TableJoueur.setItems(ListeJoueur);
        } else {
            System.err.println("Fichier pas Trouver: " + filePath);
        }
    }

    public static void loadCsv(File file) {
        ListeJoueur.clear();
        try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                String nom = nextRecord[0];
                int elo = Integer.parseInt(nextRecord[1].trim());
                Player player = new Player(nom, elo);
                ListeJoueur.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
