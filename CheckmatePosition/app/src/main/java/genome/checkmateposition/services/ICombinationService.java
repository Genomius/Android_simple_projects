package genome.checkmateposition.services;

import genome.checkmateposition.Chessman;
import genome.checkmateposition.models.Combination;

import java.util.List;

public interface ICombinationService {
    List<Chessman> findAll();
    List<Chessman> find(int id);
}
