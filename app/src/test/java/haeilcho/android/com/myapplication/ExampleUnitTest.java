package haeilcho.android.com.myapplication;

import org.junit.Test;

import java.util.Arrays;

import haeilcho.android.com.myapplication.model.Board;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Board board;

    @Test
    public void setCelltest(){
        board = new Board();
        int result[] =
                board.setCellNum();

        for(int i = 0; i < 16; i++){
            System.out.printf(Integer.toString(result[i]));
        }
    }

    public void setRandomtest(){
        board = new Board();
        int result[] =
                board.setRandomNum().clone();

        for(int i = 0; i < 8; i++){
            System.out.printf(Integer.toString(result[i]));
        }
    }
}