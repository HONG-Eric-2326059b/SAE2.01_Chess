package Chess.Piece;

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

        "deplacement diagonaux"
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

        "deplacement verticaux et horizontaux"
        for (int i = 1; PosX + i < 8; i++)
            if (addField(PosX - 1, PosY, fields))
                break;
        for (int i = 1; PosX - i >= 0; i++)
            if (addField(PosX - 1, PosY, fields))
                break;
        for (int i = 1; PosY + i < 8; i++)
            if (addField(PosX, PosY + 1, fields))
                break;
        for (int i = 1; PosY - i >= 0; i++)
            if (addField(PosX, PosY - 1, fields))
                break;
        return fields;
    }

    private boolean addField(int x, int y, List<String> fields) {
        if (fields == null) {
            fields.add(field);
            return false;
        } else if (fields.getFields.Couleur != Couleur) {
            fields.add(field);
        }
        return true;
    }
}

