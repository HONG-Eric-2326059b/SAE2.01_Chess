package Chess.Piece;

import Chess.ChessMain;

import java.util.ArrayList;
import java.util.List;

public class Dame {

    private int posX;
    private int posY;
    private Couleur couleur;
    private List<String> move;
    private int PosY;

    public Dame (Couleur couleur, int PosX, int PosY){
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
            /*mouvement diagonaux*/
            if (MoveValide(x - 1, y - 1)) move.add((x - 1) + "," + (y - 1));
            if (MoveValide(x + 1, y + 1)) move.add((x + 1) + "," + (y + 1));
            if (MoveValide(x + 1, y - 1)) move.add((x + 1) + "," + (y - 1));
            if (MoveValide(x - 1, y + 1)) move.add((x - 1) + "," + (y + 1));
            /*deplacement verticaux et horizontaux*/
            if (MoveValide(x, y - 1)) move.add((x) + "," + (y - 1));
            if (MoveValide(x, y + 1)) move.add((x) + "," + (y + 1));
            if (MoveValide(x + 1, y)) move.add((x + 1) + "," + y);
            if (MoveValide(x - 1, y)) move.add((x - 1) + "," + y);
        }
        else if (couleur.estNoir()){
            /*mouvement diagonaux*/
            if (MoveValide(x - 1, y - 1)) move.add((x - 1) + "," + (y - 1));
            if (MoveValide(x + 1, y + 1)) move.add((x + 1) + "," + (y + 1));
            if (MoveValide(x + 1, y - 1)) move.add((x + 1) + "," + (y - 1));
            if (MoveValide(x - 1, y + 1)) move.add((x - 1) + "," + (y + 1));
            /*deplacement verticaux et horizontaux*/
            if (MoveValide(x, y - 1)) move.add((x) + "," + (y - 1));
            if (MoveValide(x, y + 1)) move.add((x) + "," + (y + 1));
            if (MoveValide(x + 1, y)) move.add((x + 1) + "," + y);
            if (MoveValide(x - 1, y)) move.add((x - 1) + "," + y);
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

    /* coups possibles*/
    private ArrayList<Coordonee> CasesDispo(){
        int posX = this.posX;
        int posY = this.posY;

        ArrayList<Coordonee> possible = new ArrayList<Coordonee>();
        while (posX<8 && posX>=0 && posY>=0&& PosY<8 && getCouleur() != this.getCouleur()){
            possible.add(new Coordonee(posX, posY));
            posX++;
        }

        while (posX<8 && posX>=0 && posY>=0&& PosY<8 && getCouleur() != this.getCouleur()){
            possible.add(new Coordonee(posX, posY));
            posX--;
        }

        while (posX<8 && posX>=0 && posY>=0&& PosY<8 && getCouleur() != this.getCouleur()){
            possible.add(new Coordonee(posX, posY));
            posY++;
        }

        while (posX<8 && posX>=0 && posY>=0&& PosY<8 && getCouleur() != this.getCouleur()){
            possible.add(new Coordonee(posX, posY));
            posY--;
        }
        return possible;
    }
}

