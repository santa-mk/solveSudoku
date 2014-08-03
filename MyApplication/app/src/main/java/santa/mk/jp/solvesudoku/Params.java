package santa.mk.jp.solvesudoku;

import android.content.Context;

/**
 * Created by satan_mk on 2014/08/03.
 */
public class Params {
    public static final int SIZE = 9;
    public static int WHITE;
    public static int GRAY;

    public static void initialize(Context context) {
        WHITE = context.getResources().getColor(R.color.white);
        GRAY = context.getResources().getColor(R.color.gray);
    }
}
