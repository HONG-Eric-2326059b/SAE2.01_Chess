package Piece;


import java.util.ArrayList;


public class Cavalier {

    public Cavalier(Couleur color, ChessMain ) {
        super(color, "Cavalier", field);
    }

    @Override
    public List<> getAccessibleFields() {
        List<ChessMain> fields = new ArrayList<>();
        addField(x + 2, y + 1, fields);
        addField(x + 2, y - 1, fields);
        addField(x + 1, y + 2, fields);
        addField(x + 1, y - 2, fields);
        addField(x - 2, y + 1, fields);
        addField(x - 2, y - 1, fields);
        addField(x - 1, y + 2, fields);
        addField(x - 1, y - 2, fields);
        return fields;
}
