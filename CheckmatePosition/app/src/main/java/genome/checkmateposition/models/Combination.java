package genome.checkmateposition.models;

import android.os.Build;
import android.support.annotation.RequiresApi;
import genome.checkmateposition.Chessboard;
import genome.checkmateposition.Chessman;
import genome.checkmateposition.dao.ICombinationDao;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Combination{
    private static final int ASCII_FROM_CHAR_TO_DEC_SYMBOLS = 64;
    private static final int ASCII_FROM_CHAR_TO_DEC_DIGITS = 48;
    private int turnCountToWin;
    private int id;
    public List<Chessman> chessmen = new ArrayList<Chessman>();

    public Combination(int id, int turnCountToWin) {
        this.turnCountToWin = turnCountToWin;
        this.id = id;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addChessman(String position, String chessmanName, Chessman.Side side){
        Character positionX = Character.toUpperCase(position.charAt(0)); // A, B, C, D, E, F, G, H
        Character positionY = position.charAt(1); // 1, 2, 3, 4, 5, 6, 7, 8

        Character firstCharOfChessmanName = Character.toUpperCase(chessmanName.charAt(0));
        chessmanName = chessmanName.substring(0,0)+firstCharOfChessmanName+chessmanName.substring(1);

        int chessmanPositionX = positionX - ASCII_FROM_CHAR_TO_DEC_SYMBOLS;
        int chessmanPositionY = Chessboard.BOARD_SIZE - (positionY - ASCII_FROM_CHAR_TO_DEC_DIGITS) + 1;

        try {
            Constructor<?> constructor = Class.forName("genome.checkmateposition.Chessman" + chessmanName).
                    getConstructor(int.class, int.class, Chessman.Side.class);
            Chessman chessman = (Chessman)constructor.newInstance(chessmanPositionX, chessmanPositionY, side);
            chessmen.add(chessman);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException |
                NoSuchMethodException |InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void addWinTurn(){

    }
}
