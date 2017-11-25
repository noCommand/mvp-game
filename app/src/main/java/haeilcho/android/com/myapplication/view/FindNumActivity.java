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

    /** MVP 장점                      **특징 - Model과 View의 결합도를 낮추는데 초점
     *  View의 코드가 짧아진다.
     *  ---------------------------------------------------------
     *  Android Test를 해볼 수 있다.
     *  Presenter를 통해 데이터가 잘 받아져왔는지 검증과정도 추가할 수 있음
     *  View에 대한 테스트도 만들어 볼 수 있음
     *  --> TDD(Test-Driven development)
     *
     */

    /********* 과정 1
     *  View에서 이벤트 발생, Present에 넘김
     */
    //인터페이스를 작성한다.

    private ViewGroup buttonGrid;
    private View winnerPlayerViewGroup;
    private TextView winnerPlayerLabel;

    FindNumPresenter presenter = new FindNumPresenter(this);
    //이쪽의 view를 presenter로 넘겨준다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerPlayerLabel = (TextView) findViewById(R.id.winnerPlayerLabel);
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup);
        buttonGrid = (ViewGroup) findViewById(R.id.buttonGrid);
        presenter.onCreate();
        //presenter은 무언가를 표시하는 방법을 지시하는 대신에 표시할 내용만 전달합니다.
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
        winnerPlayerLabel.setText(winningPlayerDisplayLabel);
        winnerPlayerViewGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void clearWinnerDisplay() {
        winnerPlayerViewGroup.setVisibility(View.GONE);
        winnerPlayerLabel.setText("");
    }

    /** presenter로 넘겨줄때
     *  onCreate -> 생성할 때
     *  pause resume destroy
     *
     */


}
