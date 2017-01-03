package genome.checkmateposition.interfaces;

import genome.checkmateposition.Chessboard;

public interface ICanvasView {
    void drawChessboard(Chessboard chessboard);
    void reDraw();
}