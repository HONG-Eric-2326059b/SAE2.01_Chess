package Chess.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Pion {

    int PosX;
    int PosY;
    String Couleur;
    public Pion(Couleur,PosX,PosY){
        super(Couleur,PosX,PosY);
        ArrayList<String> move = new ArrayList<>();
    }

    public void MoveCondition(){
        int x = PosX;
        int y = PosY;
        if(Couleur == White){
            if(PosY == 6){

            }
        }
        if(Couleur == Black){
            PosY = PosY +1;

        }

    }
}
