package santa.mk.jp.solvesudoku;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by santa-mk on 2014/08/06.
 */
public class SudokuMap {
    private static final String TAG = SudokuMap.class.getSimpleName();
    private final int size;
    private Cell[][] cells;

    public SudokuMap(int size) {
        this.size = size;
        cells = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }

    public void printSudokuMap() {
        for (int i = 0; i < size; i++) {
            StringBuffer buf = new StringBuffer();
            for (int j = 0; j < size; j++) {
                buf.append(cells[i][j].getValue());
                buf.append(" ");
            }
            Log.d(TAG, buf.toString());
        }
    }

    public void markColumn(Cell cell) {
        int row = cell.getRow();
        int value = cell.getValue();
        for (int i = 0; i < size; i++) {
            cells[row][i].losePossibility(value);
        }
    }

    public void markRow(Cell cell) {
        int column = cell.getRow();
        int value = cell.getValue();
        for (int i = 0; i < size; i++) {
            cells[i][column].losePossibility(value);
        }
    }

    public void markBox(Cell cell) {
        int value = cell.getValue();
        for (Cell sameBoxCell : getSameBoxCells(cell)) {
            sameBoxCell.losePossibility(value);
        }
    }

    private Set<Cell> getSameBoxCells(Cell cell) {
        int rowGroup = cell.getRow() / 3;
        int baseRow = rowGroup * 3;
        int columnGroup = cell.getColumn() / 3;
        int baseColumn = columnGroup * 3;

        int targetRow = cell.getRow();
        int targetColumn = cell.getColumn();

        Set<Cell> sameBoxCells = new HashSet<Cell>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = baseRow + i;
                int column = baseColumn + j;

                if (row == targetRow && column == targetColumn) {
                    continue;
                }

                sameBoxCells.add(cells[row][column]);
            }
        }

        return sameBoxCells;
    }
}
