package santa.mk.jp.solvesudoku;

/**
 * Created by santa_mk on 2014/08/03.
 */
public class Cell {
    private int value;
    private final int row;
    private final int column;
    private boolean[] possibility;
    private final boolean isInput;

    public Cell(int row, int column, boolean isInput) {
        this.row = row;
        this.column = column;
        possibility = new boolean[Params.SIZE];
        for (int i = 0; i < Params.SIZE; i++) {
            possibility[i] = true;
        }
        this.isInput = isInput;
    }

    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean[] getPossibility() {
        return possibility;
    }

    public boolean isInput() {
        return isInput;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void losePossibility(int num) {
        this.possibility[num] = false;
    }
}
