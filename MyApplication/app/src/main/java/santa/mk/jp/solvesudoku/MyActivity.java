package santa.mk.jp.solvesudoku;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity {
    private static final String TAG = MyActivity.class.getSimpleName();

    private SudokuMap mValueMap;
    private Cell mSelectedCell;
    private boolean isStartedToSolve = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Params.initialize(this);
        initialize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initialize() {
        mValueMap = new SudokuMap(Params.SIZE);
        mSelectedCell = null;

        setInputListener();
        setListener();

        findViewById(R.id.solve_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStartedToSolve = true;
                mValueMap.printSudokuMap();
            }
        });

        findViewById(R.id.clear_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < Params.SIZE; i++) {
                    for (int j = 0; j < Params.SIZE; j++) {
                        mValueMap.getCell(i, j).clear();
                    }
                }

                if (mSelectedCell == null) {
                    return;
                }
                mSelectedCell.setOrgBGColorToView();
                mSelectedCell = null;
            }
        });
    }

    private void setInputListener() {
        findViewById(R.id.input1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(1);
                }
            }
        });

        findViewById(R.id.input2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(2);
                }
            }
        });

        findViewById(R.id.input3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(3);
                }
            }
        });

        findViewById(R.id.input4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(4);
                }
            }
        });

        findViewById(R.id.input5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(5);
                }
            }
        });

        findViewById(R.id.input6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(6);
                }
            }
        });

        findViewById(R.id.input7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(7);
                }
            }
        });

        findViewById(R.id.input8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(8);
                }
            }
        });

        findViewById(R.id.input9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setValue(9);
                }
            }
        });
    }

    private void setListener() {
        setCellListener(R.id.cell_00, 0, 0);
        setCellListener(R.id.cell_01, 0, 1);
        setCellListener(R.id.cell_02, 0, 2);
        setCellListener(R.id.cell_03, 0, 3);
        setCellListener(R.id.cell_04, 0, 4);
        setCellListener(R.id.cell_05, 0, 5);
        setCellListener(R.id.cell_06, 0, 6);
        setCellListener(R.id.cell_07, 0, 7);
        setCellListener(R.id.cell_08, 0, 8);

        setCellListener(R.id.cell_10, 1, 0);
        setCellListener(R.id.cell_11, 1, 1);
        setCellListener(R.id.cell_12, 1, 2);
        setCellListener(R.id.cell_13, 1, 3);
        setCellListener(R.id.cell_14, 1, 4);
        setCellListener(R.id.cell_15, 1, 5);
        setCellListener(R.id.cell_16, 1, 6);
        setCellListener(R.id.cell_17, 1, 7);
        setCellListener(R.id.cell_18, 1, 8);

        setCellListener(R.id.cell_20, 2, 0);
        setCellListener(R.id.cell_21, 2, 1);
        setCellListener(R.id.cell_22, 2, 2);
        setCellListener(R.id.cell_23, 2, 3);
        setCellListener(R.id.cell_24, 2, 4);
        setCellListener(R.id.cell_25, 2, 5);
        setCellListener(R.id.cell_26, 2, 6);
        setCellListener(R.id.cell_27, 2, 7);
        setCellListener(R.id.cell_28, 2, 8);

        setCellListener(R.id.cell_30, 3, 0);
        setCellListener(R.id.cell_31, 3, 1);
        setCellListener(R.id.cell_32, 3, 2);
        setCellListener(R.id.cell_33, 3, 3);
        setCellListener(R.id.cell_34, 3, 4);
        setCellListener(R.id.cell_35, 3, 5);
        setCellListener(R.id.cell_36, 3, 6);
        setCellListener(R.id.cell_37, 3, 7);
        setCellListener(R.id.cell_38, 3, 8);

        setCellListener(R.id.cell_40, 4, 0);
        setCellListener(R.id.cell_41, 4, 1);
        setCellListener(R.id.cell_42, 4, 2);
        setCellListener(R.id.cell_43, 4, 3);
        setCellListener(R.id.cell_44, 4, 4);
        setCellListener(R.id.cell_45, 4, 5);
        setCellListener(R.id.cell_46, 4, 6);
        setCellListener(R.id.cell_47, 4, 7);
        setCellListener(R.id.cell_48, 4, 8);

        setCellListener(R.id.cell_50, 5, 0);
        setCellListener(R.id.cell_51, 5, 1);
        setCellListener(R.id.cell_52, 5, 2);
        setCellListener(R.id.cell_53, 5, 3);
        setCellListener(R.id.cell_54, 5, 4);
        setCellListener(R.id.cell_55, 5, 5);
        setCellListener(R.id.cell_56, 5, 6);
        setCellListener(R.id.cell_57, 5, 7);
        setCellListener(R.id.cell_58, 5, 8);

        setCellListener(R.id.cell_60, 6, 0);
        setCellListener(R.id.cell_61, 6, 1);
        setCellListener(R.id.cell_62, 6, 2);
        setCellListener(R.id.cell_63, 6, 3);
        setCellListener(R.id.cell_64, 6, 4);
        setCellListener(R.id.cell_65, 6, 5);
        setCellListener(R.id.cell_66, 6, 6);
        setCellListener(R.id.cell_67, 6, 7);
        setCellListener(R.id.cell_68, 6, 8);

        setCellListener(R.id.cell_70, 7, 0);
        setCellListener(R.id.cell_71, 7, 1);
        setCellListener(R.id.cell_72, 7, 2);
        setCellListener(R.id.cell_73, 7, 3);
        setCellListener(R.id.cell_74, 7, 4);
        setCellListener(R.id.cell_75, 7, 5);
        setCellListener(R.id.cell_76, 7, 6);
        setCellListener(R.id.cell_77, 7, 7);
        setCellListener(R.id.cell_78, 7, 8);

        setCellListener(R.id.cell_80, 8, 0);
        setCellListener(R.id.cell_81, 8, 1);
        setCellListener(R.id.cell_82, 8, 2);
        setCellListener(R.id.cell_83, 8, 3);
        setCellListener(R.id.cell_84, 8, 4);
        setCellListener(R.id.cell_85, 8, 5);
        setCellListener(R.id.cell_86, 8, 6);
        setCellListener(R.id.cell_87, 8, 7);
        setCellListener(R.id.cell_88, 8, 8);
    }

    private void setCellListener(int id, final int row, final int column) {
        TextView v = (TextView) findViewById(id);
        mValueMap.getCell(row, column).setTextView(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedCell != null) {
                    mSelectedCell.setOrgBGColorToView();
                }

                mSelectedCell = mValueMap.getCell(row, column);
                mSelectedCell.getTextView().setBackgroundColor(Color.BLACK);
            }
        });
    }


}
