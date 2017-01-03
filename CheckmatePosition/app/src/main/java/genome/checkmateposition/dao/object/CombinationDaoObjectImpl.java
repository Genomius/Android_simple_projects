package genome.checkmateposition.dao.object;

import android.os.Build;
import android.support.annotation.RequiresApi;
import genome.checkmateposition.dao.ICombinationDao;
import genome.checkmateposition.models.Combination;

import java.util.List;

public class CombinationDaoObjectImpl implements ICombinationDao {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public Combination find(int id) {
        return CombinationObject.getCombinationById(0);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public List<Combination> findAll() {
        return CombinationObject.getAllCombinations();
    }
}
