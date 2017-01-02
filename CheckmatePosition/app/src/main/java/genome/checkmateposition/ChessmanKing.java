package genome.checkmateposition;

public class ChessmanKing extends Chessman {
    public ChessmanKing(int positionX, int positionY, Side side) {
        super(positionX, positionY, side);

        if(side == Side.WHITE)
            super.sprite = R.drawable.white_king;
        else
            super.sprite = R.drawable.black_king;
    }
}
