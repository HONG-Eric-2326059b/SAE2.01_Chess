package Chess.Piece;

import Chess.Controllers.NouvellePController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pion {
    private int posX;
    private int posY;
    private Couleur couleur;
    private ImageView image;
    private List<String> move;
    private Map<Shape, String> posPossibles = new HashMap<>();

    public Pion(Couleur couleur, int posX, int posY,ImageView image) {
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

        if (couleur.estNoir()) {
            if (MoveValide(x - 1, y - 1)) move.add((x - 1) + "," + (y - 1));
            if (MoveValide(x, y - 1)) move.add((x) + "," + (y - 1));
            if (MoveValide(x + 1, y - 1)) move.add((x + 1) + "," + (y - 1));

            if (posY == 6) {
                 if (MoveValide(x, y - 2)) move.add((x)+ "," + (y - 2));
            }
        } else if (couleur.estBlanc()) {
            if (MoveValide(x - 1, y + 1)) move.add((x - 1) + "," + (y + 1));
            if (MoveValide(x, y + 1)) move.add((x) + "," + (y + 1));
            if (MoveValide(x + 1, y + 1)) move.add((x + 1) + "," + (y + 1));
            if (posY == 1) {
                if (MoveValide(x, y + 2)) move.add((x) + "," + (y + 2));
            }
        }
    }

    public void upgrade(){
        int y = posY;
        if(posY == 0 && couleur.estBlanc()){

        }
        if (posY == 7 && couleur.estNoir()){

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
    public ImageView getImage() {
        return image;
    }
    public void deplacePion(GridPane plateau){
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

