package genome.checkmateposition;

import android.graphics.Color;

public class Chessboard implements IChessboard {
    public static final int BOARD_SIZE = 8;
    private static final int LIGHT_CELL_COLOR = Color.LTGRAY;
    private static final int DARK_CELL_COLOR = Color.DKGRAY;

    public int getColor(int index) {
        if(index % 2 == 0){
            return LIGHT_CELL_COLOR;
        }
        else{
            return DARK_CELL_COLOR;
        }
    }
}
