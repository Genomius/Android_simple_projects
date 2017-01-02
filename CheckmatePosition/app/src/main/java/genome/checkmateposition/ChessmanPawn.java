package genome.checkmateposition;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ChessmanPawn extends Chessman {
    public ChessmanPawn(int positionX, int positionY, Side side) {
        super(positionX, positionY, side);

        if(side == Side.WHITE)
            super.sprite = R.drawable.white_pawn;
        else
            super.sprite = R.drawable.black_pawn;
    }
}
