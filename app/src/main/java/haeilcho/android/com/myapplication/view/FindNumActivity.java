package haeilcho.android.com.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import haeilcho.android.com.myapplication.R;
import haeilcho.android.com.myapplication.presenter.FindNumPresenter;

public class FindNumActivity extends AppCompatActivity implements FindNumView {
    private static final String TAG = FindNumView.class.getName();

    /********* 과정 1
     *  View에서 이벤트 발생, Present에 넘김
     */

    private ViewGroup buttonGrid;
    private View winnerPlayerViewGroup;

    FindNumPresenter presenter = new FindNumPresenter(this);
    //이쪽의 view를 presenter로 넘겨준다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup);
        buttonGrid = (ViewGroup) findViewById(R.id.buttonGrid);
        presenter.onCreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.set_default:
                presenter.onResetSelected();
                /**
                 * reset버튼을 누르면 presenter로 눌렸다고 전달 -> reset해라
                 */
                return true;
            default:
                return super.onOptionsItemSelected(item);
            /**
             * 아니면 말고
             */
        }
    }

    public void onCellClicked(View v) {

        Button button = (Button) v;
        String tag = button.getTag().toString();
        int row = Integer.valueOf(tag.substring(0,1));
        int col = Integer.valueOf(tag.substring(1,2));
        Log.i(TAG, "Click Row: [" + row + "," + col + "]");

        presenter.onButtonSelected(row, col);
        /**
         *  presenter로 눌려진 데이터만 전달 (칼럼 위치) -> 눌린 버튼
         */
    }

    @Override
    public void setButtonText(int row, int col, String text) {
        Button btn = (Button) buttonGrid.findViewWithTag("" + row + col);
        if(btn != null) {
            btn.setText(text);
        }
    }

    @Override
    public void clearButtons() {
        for( int i = 0; i < buttonGrid.getChildCount(); i++ ) {
            ((Button) buttonGrid.getChildAt(i)).setText("");
        }
    }


    @Override
    public void showWinner(String winningPlayerDisplayLabel) {
        winnerPlayerViewGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void clearWinnerDisplay() {
        winnerPlayerViewGroup.setVisibility(View.GONE);
    }

    /** presenter로 넘겨줄때
     *  onCreate -> 생성할 때
     *  pause resume destroy ->아는데로
     *  onOptionsItemSelected 초기화를 눌렀을 때 presenter에서 정의된 행동을 취해라 (reset)
     *  onCellClicked 버튼을 누르게 되면 칼럼 위치를 presenter로 (각각 칸을 누르게 되면)
     */


}
