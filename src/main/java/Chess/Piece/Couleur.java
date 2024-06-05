package Chess.Piece;

public class Couleur {

    public static final String BLACK = "BLACK";
    public static final String WHITE = "WHITE";

    private String couleur;

    //
    public Couleur(String couleur) {
        if (couleur.equals(BLACK) || couleur.equals(WHITE)) {
            this.couleur = couleur;
        }
    }

    //Revoie la couleur
    public String getCouleur() {
        return couleur;
    }
    //renvoie True si la couleur est Noir
    public boolean estNoir() {
        return BLACK.equals(couleur);
    }
    //revoie True si la couleur est blanc
    public boolean estBlanc() {
        return WHITE.equals(couleur);
    }
}

