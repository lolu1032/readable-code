package cleancode.minesweeper.tobe.minesweeper.gamelevel;

public class Advanced implements GameLevel {

    @Override
    public int getRowSize() {
        return 199;
    }

    @Override
    public int getColSize() {
        return 190;
    }

    @Override
    public int getLandMineCount() {
        return 99;
    }

}
