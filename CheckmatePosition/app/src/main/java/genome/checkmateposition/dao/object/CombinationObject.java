package genome.checkmateposition.dao.object;

import android.os.Build;
import android.support.annotation.RequiresApi;
import genome.checkmateposition.*;
import genome.checkmateposition.models.Combination;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class CombinationObject{
    private static List<Combination> combinations = new ArrayList<Combination>();

    static{
        combinations.add(getObject1());
    }

    public static Combination getCombinationById(int id){
        return combinations.get(id);
    }

    public static List<Combination> getAllCombinations(){
        return combinations;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Combination getObject1(){
        Combination combination = new Combination(0, 2);

        combination.addChessman("C1", "king", Chessman.Side.BLACK);
        combination.addChessman("F1", "king", Chessman.Side.WHITE);
        combination.addChessman("C2", "pawn", Chessman.Side.BLACK);
        combination.addChessman("C3", "pawn", Chessman.Side.BLACK);
        combination.addChessman("D2", "knight", Chessman.Side.WHITE);
        combination.addChessman("F2", "knight", Chessman.Side.WHITE);
        combination.addChessman("H6", "queen", Chessman.Side.WHITE);

        return combination;
    }
}
