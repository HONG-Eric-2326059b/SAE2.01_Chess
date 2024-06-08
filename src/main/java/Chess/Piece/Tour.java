package Chess.Piece;

import Chess.Controllers.NouvellePController;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tour {

    private int posX;
    private int posY;
    private Couleur couleur;
    private List<String> move;
    private ImageView image;
    private Map<Shape,String> posPossibles= new HashMap<>();

    public Tour (Couleur couleur, int PosX, int PosY,ImageView image){
        this.couleur = couleur;
        this.posX = posX;
        this.posY = posY;
        this.image = image;
        this.move = new ArrayList<>();
    }

    public void moveCondition() {
        int x = posX;
        int y = posY;
        move.clear();
        /* déplacements verticaux et horizontaux */
        // Déplacements vers le haut
        for (int i = y - 1; i >= 0; i--) {
            if (MoveValide(x, i)) move.add(x + "," + i);
        }
        // Déplacements vers le bas
        for (int i = y + 1; i < 8; i++) {
            if (MoveValide(x, i)) move.add(x + "," + i);
        }
        // Déplacements vers la droite
        for (int i = x + 1; i < 8; i++) {
            if (MoveValide(i, y)) move.add(i + "," + y);
        }
        // Déplacements vers la gauche
        for (int i = x - 1; i >= 0; i--) {
            if (MoveValide(i, y)) move.add(i + "," + y);
        }
    }


    private boolean MoveValide(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public ImageView getImage() {return image; }

    public void deplaceTours(GridPane plateau){
        //Supprime les carrés jaune du GridPane
        plateau.getChildren().remove(plateau.getChildren().size()- posPossibles.size(), plateau.getChildren().size());
        posPossibles.clear();
        moveCondition();
        for (String pos : move){
            Shape r = new Rectangle(75, 75, new Color(0.99, 1, 0, 0.45));
            // ajoute les rectangles dans le GridPane
            plateau.add(r, Character.getNumericValue(pos.charAt(0)), 7-Character.getNumericValue(pos.charAt(2)));
            // associe une position à chaque rectangle
            posPossibles.put(r,Plateau.colonneToPos(Character.getNumericValue(pos.charAt(0)))+Character.getNumericValue(pos.charAt(2)+1));
        }
        for (Shape n : posPossibles.keySet()){
            // Si on appuie sur un rectangle
            n.setOnMouseClicked(actionEvent -> {
                plateau.getChildren().remove(plateau.getChildren().size()- posPossibles.size(), plateau.getChildren().size());
                System.out.println(posPossibles.get(n));
                //Met à jour la position de la tours
                posY = Character.getNumericValue(posPossibles.get(n).charAt(1))-1;
                posX = posPossibles.get(n).charAt(0) - 'a';
                // Déplace la pièce dans le GridPane
                NouvellePController.deplacePiece(posPossibles.get(n),this.image,plateau);
                posPossibles.clear();
            });
        }
    }
}
