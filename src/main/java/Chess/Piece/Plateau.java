package Chess.Piece;

import javafx.scene.image.ImageView;

import java.util.*;

public class Plateau {
    private Map<ImageView, String> plateau;

    public Plateau() {
        this.plateau = new HashMap<>();
    }

    public Map<ImageView, String> getPlateau() {
        return plateau;
    }

    public static int posToLigne(String pos) {
        return 7 - Character.getNumericValue(pos.charAt(1));
    }
    public static String ligneToPos(int pos) {
        return Integer.toString(pos + 8);
    }
    public static String colonneToPos(int pos) {
        return Character.toString(pos + 'a');
    }

    public static int posToColonne(String pos) {
        return pos.charAt(0) - 'a';
    }

    public void setPiece(ImageView piece, int ligne, int colonne) {
        String lig = Integer.toString(ligne + 8);
        char[] col = Character.toChars(colonne + 'a');
        plateau.remove(piece);
        plateau.put(piece, String.valueOf(col) + lig);
    }

    public void setPiece(ImageView piece, String position) {
        plateau.remove(piece);
        plateau.put(piece, position);
    }

    public int getLigne(ImageView piece) {
        String pos = plateau.get(piece);
        return 8 - Character.getNumericValue(pos.charAt(1));
    }

    public int getColonne(ImageView piece) {
        String pos = plateau.get(piece);
        return pos.charAt(0) - 'a';
    }
//    public  static void main(String[] args){
//}
}