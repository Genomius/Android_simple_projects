package genome.checkmateposition.dao;

import genome.checkmateposition.Chessman;
import genome.checkmateposition.models.Combination;

import java.util.List;

public interface ICombinationDao {
    Combination find(int id);
    List<Combination> findAll();
}
