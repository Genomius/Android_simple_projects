package genome.checkmateposition;

import android.graphics.Color;
import genome.checkmateposition.interfaces.IChessboard;

public class Chessboard implements IChessboard {
    public static final int BOARD_SIZE = 8;
    private static final int LIGHT_CELL_COLOR = Color.rgb(111, 65, 41); // Color.LTGRAY;
    private static final int DARK_CELL_COLOR = Color.rgb(192, 146, 123); // Color.DKGRAY;

    public int getColor(int index) {
        if(index % 2 == 0){
            return LIGHT_CELL_COLOR;
        }
        else{
            return DARK_CELL_COLOR;
        }
    }
}
