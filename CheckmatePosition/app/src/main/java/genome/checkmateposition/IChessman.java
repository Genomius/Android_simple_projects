package genome.checkmateposition;

public interface IChessman {
    enum Chessmen{
        PAWN, BISHOP, KNIGHT, CASTLE, QUEEN, KING
    }

    void move(IChessman chessman);
    void remove(IChessman chessman);

}
