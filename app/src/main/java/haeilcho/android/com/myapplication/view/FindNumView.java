package haeilcho.android.com.myapplication.view;

/**
 * Created by HaeilCho on 2017-11-25.
 */

public interface FindNumView {
    void showWinner(String winningPlayerDisplayLabel);
    void clearWinnerDisplay();
    void clearButtons();
    void setButtonText(int row, int col, String text);
}
