package Chess.Piece;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Chess.Piece.Couleur;


public class Pion {

    int PosX;
    int PosY;

    public Pion(Couleur,PosX,PosY){
        super(Couleur,PosX,PosY);
    }


    public void MoveCondition(){
        int x = PosX;
        int y = PosY;
        if(Couleur == White){
            move.add((x-1) + (y-1));
            move.add((x) + (y-1));
            move.add((x+1) + (y-1));
            if(PosY == 6){
                move.add((y-1)) ||  move.add((y-2));
            }
        }
        if(Couleur == Black){
            if(PosY == 1){
                move.add((x+1) + (y+1));
                move.add((x) + (y+1));
                move.add((x-1) + (y+1));
                if(Couleur == Black){
                    move.add((y+1)) ||  move.add((y+2));
                }
            }
        }

    }
}
