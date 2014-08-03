package santa.mk.jp.solvesudoku;

import android.widget.TextView;

/**
 * Created by santa_mk on 2014/08/03.
 */
public class Cell {
    private int value;
    private final int row;
    private final int column;
    private boolean[] possibility;
    private boolean isInput;
    private TextView textView;
    private int orgBgColor;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        possibility = new boolean[Params.SIZE];
        for (int i = 0; i < Params.SIZE; i++) {
            possibility[i] = true;
        }
        orgBgColor = calcOrgBgColor();
        value = -1;
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

    public TextView getTextView() {
        return textView;
    }

    public boolean isInput() {
        return isInput;
    }

    public void setValue(int value) {
        this.value = value;
        textView.setText(String.valueOf(value));
    }

    public void setInput(boolean isInput) {
        this.isInput = isInput;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void losePossibility(int num) {
        this.possibility[num] = false;
    }

    public void setOrgBGColorToView() {
        textView.setBackgroundColor(orgBgColor);
    }

    public void clear() {
        value = -1;
        textView.setText("");
    }

    private int calcOrgBgColor() {
        if (row < 3) {
            if (column > 2 && column < 6) {
                return Params.GRAY;
            }
        } else if (row < 6) {
            if (column < 3 || column > 5) {
                return Params.GRAY;
            }
        } else {
            if (column > 2 && column < 6) {
                return Params.GRAY;
            }
        }

        return Params.WHITE;
    }
}
