package Chess.Piece;
import Chess.ChessMain;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class MovePiece {

    @FXML
    private void DragOver(DragEvent event){
        event.acceptTransferModes(TransferMode.ANY);
    }
    @FXML
    private void DragDrop(DragEvent event, ImageView imageView) throws FileNotFoundException {
        List<File> files = (List<File>) event.getDragboard().getFiles();
        if (!files.isEmpty()) {
            Image piece = new Image(new FileInputStream(files.get(0)));
            imageView.setImage(piece);
        }
    }
}
