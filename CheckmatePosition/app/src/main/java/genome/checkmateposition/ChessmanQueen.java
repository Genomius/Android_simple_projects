package genome.checkmateposition;

public class ChessmanQueen extends Chessman{

    public ChessmanQueen(int positionX, int positionY, Side side) {
        super(positionX, positionY, side);

        if(side == Side.WHITE)
            super.sprite = R.drawable.white_queen;
        else
            super.sprite = R.drawable.black_queen;
    }
}
