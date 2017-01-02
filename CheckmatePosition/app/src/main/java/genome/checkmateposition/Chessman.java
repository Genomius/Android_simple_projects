package genome.checkmateposition;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;

public class Chessman implements IChessman{
    protected int sprite;
    protected enum Side { WHITE, BLACK };
    private int positionX;
    private int positionY;
    private Side side;

    public Chessman(int positionX, int positionY, Side side) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.side = side;
    }

    public int getSprite() {
        return this.sprite;
    }


    public Side getSide() {
        return side;
    }

    public int getColor(){
        if(side == side.WHITE)
            return 0;
        return 1;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionX() {
        return positionX;
    }


    @Override
    public void move(IChessman chessman) {

    }

    @Override
    public void remove(IChessman chessman) {

    }

}
