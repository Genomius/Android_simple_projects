package genome.checkmateposition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class CanvasView extends View implements ICanvasView{
    private GameManager gameManager;
    private Canvas canvas;
    Paint paint;
    private static final int CELL_SIZE_PX = 100;
    private static final int FIRST_CELL_POSITION_X = 100;
    private static final int FIRST_CELL_POSITION_Y = 100;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        gameManager = new GameManager(this);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();
    }

    @Override
    public void drawChessboard(Chessboard chessboard) {
        int currentPositionX = FIRST_CELL_POSITION_X;
        int currentPositionY = FIRST_CELL_POSITION_Y;

        for (int i = 0; i < Chessboard.BOARD_SIZE; i++, currentPositionY += CELL_SIZE_PX) {
            for (int j = 0; j < Chessboard.BOARD_SIZE; j++, currentPositionX += CELL_SIZE_PX) {
                paint.setColor(chessboard.getColor(j+i));
                Rect cell = new Rect(currentPositionX, currentPositionY,
                        currentPositionX + CELL_SIZE_PX, currentPositionY + CELL_SIZE_PX);
                canvas.drawRect(cell, paint);

                if (j == Chessboard.BOARD_SIZE - 1)
                    currentPositionX = FIRST_CELL_POSITION_X - CELL_SIZE_PX;
            }
        }
    }

    @Override
    public void reDraw() {

    }

    public void drawChessmen(List<Chessman> chessmen) {
        for (Chessman chessman : chessmen) {
            int positionX = FIRST_CELL_POSITION_X + chessman.getPositionX() * CELL_SIZE_PX - CELL_SIZE_PX;
            int positionY = FIRST_CELL_POSITION_Y + chessman.getPositionY() * CELL_SIZE_PX - CELL_SIZE_PX;

            Resources res = this.getResources();
            Bitmap mBitmap = BitmapFactory.decodeResource(res, chessman.getSprite());
            mBitmap = Bitmap.createScaledBitmap(mBitmap, 100, 100, false);
            canvas.drawBitmap(mBitmap, positionX, positionY, paint);
        }
    }
}
