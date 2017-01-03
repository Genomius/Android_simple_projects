package genome.checkmateposition;

import genome.checkmateposition.dao.ICombinationDao;
import genome.checkmateposition.dao.object.CombinationDaoObjectImpl;
import genome.checkmateposition.factories.ChessmenDataFactory;
import genome.checkmateposition.models.Combination;
import genome.checkmateposition.services.CombinationService;
import genome.checkmateposition.services.ICombinationService;
import genome.checkmateposition.view.CanvasView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private CanvasView canvasView;
    Chessboard chessboard;
    List<Chessman> chessmen = new ArrayList<Chessman>();

    public GameManager(CanvasView canvasView) {
        this.canvasView = canvasView;
        initChessboard();
        initChessmen();
    }

    private void initChessmen() {
        //ICombinationDao combinationDao = ChessmenDataFactory.getInstance().getCombinationDao();
        //CombinationService combinationService = new CombinationService(combinationDao);
        //chessmen.addAll(combinationService.findAll());

        ICombinationDao combinationDao = new CombinationDaoObjectImpl();
        ICombinationService combinationService = new CombinationService(combinationDao);
        chessmen.addAll(combinationService.find(0));

//        chessmen.add(new ChessmanPawn(3, 7, Chessman.Side.BLACK));
//        chessmen.add(new ChessmanPawn(3, 6, Chessman.Side.BLACK));
//        chessmen.add(new ChessmanKing(3, 8, Chessman.Side.BLACK));
//        chessmen.add(new ChessmanKing(6, 8, Chessman.Side.WHITE));
//        chessmen.add(new ChessmanQueen(8, 3, Chessman.Side.WHITE));
//        chessmen.add(new ChessmanKnight(4, 7, Chessman.Side.WHITE));
//        chessmen.add(new ChessmanKnight(6, 7, Chessman.Side.WHITE));
    }

    private void getGamePosition(){

    }

    private void initChessboard() {
        chessboard = new Chessboard();
    }

    public void onDraw() {
        canvasView.drawChessboard(chessboard);
        canvasView.drawChessmen(chessmen);
    }
}
