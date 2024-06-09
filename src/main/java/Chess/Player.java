package Chess;

public class Player {
    private String Nom;
    private String Prenom;
    private int PartiesJouer;
    private int PartiesGagner;

    // Constructor
    public Player(String Nom, String Prenom, int PartiesJouer, int PartiesGagner) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.PartiesJouer = PartiesJouer;
        this.PartiesGagner = PartiesGagner;
    }

    // Getters and setters
    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public int getPartiesJouer() {
        return PartiesJouer;
    }

    public void setPartiesJouer(int PartiesJouer) {
        this.PartiesJouer = PartiesJouer;
    }

    public int getPartiesGagner() {
        return PartiesGagner;
    }

    public void setPartiesGagner(int PartiesGagner) {
        this.PartiesGagner = PartiesGagner;
    }
}
