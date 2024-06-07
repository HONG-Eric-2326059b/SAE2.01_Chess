package Chess.Piece;

import java.util.ArrayList;
import java.util.List;

public class Pion {
    private int posX;
    private int posY;
    private Couleur couleur;
    private List<String> move;

    public Pion(Couleur couleur, int posX, int posY) {
        this.couleur = couleur;
        this.posX = posX;
        this.posY = posY;
        this.move = new ArrayList<>();
    }

    public void moveCondition() {
        int x = posX;
        int y = posY;
        move.clear();

        if (couleur.estBlanc()) {
            if (MoveValide(x - 1, y - 1)) move.add((x - 1) + "," + (y - 1));
            if (MoveValide(x, y - 1)) move.add((x) + "," + (y - 1));
            if (MoveValide(x + 1, y - 1)) move.add((x + 1) + "," + (y - 1));
            if (posY == 6) {
                 if (MoveValide(x, y - 2)) move.add((x)+ "," + (y - 2));
            }
        } else if (couleur.estNoir()) {
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
}

