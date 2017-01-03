package genome.checkmateposition.dao.file;

import genome.checkmateposition.dao.ICombinationDao;
import genome.checkmateposition.models.Combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationDaoFileImpl implements ICombinationDao {
    private String fileName;

    public CombinationDaoFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Combination find(int id) {
        return null;
    }

    @Override
    public List<Combination> findAll() {
        List<Combination> combinations = new ArrayList<Combination>();
        String data = FileAndData.getFileData(fileName);

        return combinations;
    }
}
