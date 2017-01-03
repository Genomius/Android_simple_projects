package genome.checkmateposition.services;

import android.os.Build;
import android.support.annotation.RequiresApi;
import genome.checkmateposition.Chessman;
import genome.checkmateposition.dao.ICombinationDao;
import genome.checkmateposition.models.Combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationService implements ICombinationService{
    private ICombinationDao combinationDao;

    public CombinationService(ICombinationDao combinationDao) {
        this.combinationDao = combinationDao;
    }

    @Override
    public List<Chessman> find(int id){
        Combination combination = combinationDao.find(id);

        return combination.chessmen;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public List<Chessman> findAll() {
        List<Chessman> chessmen = new ArrayList<Chessman>();
        List<Combination> combinations = combinationDao.findAll();

        for (Combination combination : combinations) {
            // ToDo: Проверка на количество фигур и королей

        }

        return chessmen;
    }
}
