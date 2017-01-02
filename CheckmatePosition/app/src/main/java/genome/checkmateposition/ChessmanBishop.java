package genome.checkmateposition;

public class ChessmanBishop extends Chessman {
    public ChessmanBishop(int positionX, int positionY, Side side) {
        super(positionX, positionY, side);

        if(side == Side.WHITE)
            super.sprite = R.drawable.white_bishop;
        else
            super.sprite = R.drawable.black_bishop;
    }
}
