package genome.checkmateposition;

public class ChessmanKnight extends Chessman {
    public ChessmanKnight(int positionX, int positionY, Side side) {
        super(positionX, positionY, side);

        if(side == Side.WHITE)
            super.sprite = R.drawable.white_knight;
        else
            super.sprite = R.drawable.black_knight;
    }
}
