package cleancode.minesweeper.asis;

public class Cell {

    private static final String LAND_MINE_SIGN = "☼";
    private static final String FLAG_SIGN = "⚑";
    private static final String UNCHECKED_SIGN = "□";
    private static final String EMPTY_SIGN = "■";

    private int nearbyLandMineCount;
    private boolean isLandMine;
    private boolean isFlagged;
    private boolean isOpened;

    // Cell이 가진 속성 : 근처 지회 숫자, 지뢰여부
    // Cell의 상태 : 깃발 유무, 열렸다/닫혔다, 사용자가 확인함

    public Cell(int nearbyLandMineCount , boolean isLandMine,boolean isFlagged,boolean isOpend) {
        this.nearbyLandMineCount = nearbyLandMineCount;
        this.isLandMine = isLandMine;
        this.isFlagged = isFlagged;
        this.isOpened = isOpend;
    }

    public static Cell of(int nearbyLandMineCount , boolean isLandMine,boolean isFlagged,boolean isOpend) {
        return new Cell(nearbyLandMineCount,isLandMine,isFlagged,isOpend);
    }


    public static Cell create() {
        return of(0,false,false, false);
    }

    public void turnONLandMine() {
        this.isLandMine = true;
    }


    public void updateNearbyLandMineCount(int count) {
        this.nearbyLandMineCount= count;
    }

    public boolean isChecked() {
        return isFlagged || isOpened;
    }

    public boolean isLandMine() {
        return isLandMine;
    }

    public void flag() {
        this.isFlagged = true;
    }
    public void open() {
        this.isOpened = true;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean hasLandMineCount() {
        return this.nearbyLandMineCount != 0;
    }

    public String getSign() {
        if(isOpened) {
            if(isLandMine) {
                return LAND_MINE_SIGN;
            }
            if(hasLandMineCount()) {
                return String.valueOf(nearbyLandMineCount);
            }
            return EMPTY_SIGN;
        }

        if(isFlagged) {
            return FLAG_SIGN;
        }
        return UNCHECKED_SIGN;
    }
}

