package haeilcho.android.com.myapplication.presenter;

import haeilcho.android.com.myapplication.model.Board;
import haeilcho.android.com.myapplication.model.Player;
import haeilcho.android.com.myapplication.view.FindNumView;

/**
 * Created by HaeilCho on 2017-11-25.
 */

public class FindNumPresenter implements Presenter {
    /*
        MVC Controller에서는
        애플리케이션에서 발생하는 일을 담당하는 마스터 컨트롤러 역할
        뷰가 컨트롤러에게 사용자가 버튼을 눌렀다고 알리면,
        컨트롤러는 그에 따라 어떻게 모델과 상호작용할지 결정
    */
    /**
     *   MVC의 controller과는 다르게 무언가를 표시하는 방법을 지시하는 대신
     *   표시할 내용만 전달
     */

    /********* 과정 2
     *  View에서 발생한 이벤트를 Present에서 받아서 처리
     *  이 과정에서 Data가 필요할 경우 Model에서 처리하고, Presenter를 이용하여 View에 전달
     */

    private FindNumView view;
    private Board model;

    public FindNumPresenter(FindNumView view){ //생성자
        this.view = view;
        this.model = new Board();
    }
    @Override
    public void onCreate() {
        model = new Board();
        //board 생성
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onButtonSelected(int row, int col) {
        Player playerThatMoved = model.mark(row, col);

        if(playerThatMoved != null) {
            view.setButtonText(row, col, playerThatMoved.toString());

            if (model.getWinner() != null) {
                view.showWinner(playerThatMoved.toString());
            }
        }
    }

    public void onResetSelected() {
        view.clearWinnerDisplay();
        view.clearButtons();
        model.restart();
    }


}
