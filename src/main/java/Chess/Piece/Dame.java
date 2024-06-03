package Piece;

import java.util.ArrayList;
import java.util.List;

public class Dame {

    int PosX;
    int PosY;
    String Couleur;
    public Dame (Couleur, PosX, PosY){
        super(Couleur,PosX,PosY);
        ArrayList<String> move = new ArrayList<>();
    }

    public List<String> getFields() {
        List<String> fields = new ArrayList<>();
        int x = PosX;
        int y= PosY;

        for (int i = 1; PosX + i < 8 && PosY + i < 8; i++)
            if (addField(PosX + 1, PosY + 1, fields))
                break;
        for (int i = 1; PosX + i < 8 && PosY - i >= 0; i++)
            if (addField(PosX + 1, PosY - 1, fields))
                break;
        for (int i = 1; PosX - i >= 0 && PosY - i >= 0; i++)
            if (addField(PosX + 1, PosY + 1, fields))
                break;
        for (int i = 1; PosX - i >= 0 && PosY + i < 8; i++)
            if (addField(PosX - 1, PosY + 1, fields))
                break;
        for (int i = 1; PosX + i < 8; i++)
            if (addField(PosX - 1, fields))
                break;
        for (int i = 1; PosX - i >= 0; i++)
            if (addField(PosX - 1, fields))
                break;
        for (int i = 1; PosY + i < 8; i++)
            if (addField(PosY + 1, fields))
                break;
        for (int i = 1; PosY - i >= 0; i++)
            if (addField(PosY - 1, fields))
                break;
        return fields;
    }

    private boolean addField(int x, int y, List<String> fields){

    }

}
