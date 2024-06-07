package Chess;


public class Player extends ChessMain{
    private String Nom;
    private int elo;

    public Player(String Nom,int elo){
        this.Nom = Nom;
        this.elo = elo;
    }

    private void getNom(){
        this.Nom = Nom;
    }
    private void getelo(){
        this.elo= elo;
    }
    private void setNom(String Nom){
        this.Nom = Nom;
    }
    private void setElo(int elo){
        this.elo = elo;
    }


}


