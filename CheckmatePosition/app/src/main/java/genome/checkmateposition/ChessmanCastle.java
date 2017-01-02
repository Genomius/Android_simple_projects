package genome.checkmateposition;

public class ChessmanCastle extends Chessman {
    public ChessmanCastle(int positionX, int positionY, Side side) {
        super(positionX, positionY, side);

        if(side == Side.WHITE)
            super.sprite = R.drawable.white_castle;
        else
            super.sprite = R.drawable.black_castle;
    }
}
