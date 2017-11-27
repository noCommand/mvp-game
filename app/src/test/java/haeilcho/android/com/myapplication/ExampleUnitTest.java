package haeilcho.android.com.myapplication;

import org.junit.Test;

import haeilcho.android.com.myapplication.model.Board;
import haeilcho.android.com.myapplication.model.Cell;

import static org.hamcrest.core.Is.is;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Board board;




    @Test
    public void setCellTest(){

        Cell[][] cells = new Cell[4][4];

        board = new Board();

        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j++){
                System.out.printf(Integer.toString(cells[i][j].getNumValue()));
            }
        }
    }

    public void setArrayTest(){
        board = new Board();
        int result[] =
                board.setArrayNum();

        for(int i = 0; i < 16; i++){
            System.out.printf(Integer.toString(result[i]));
        }
    }

    public void setRandomTest(){
        board = new Board();
        int result[] =
                board.setRandomNum().clone();

        for(int i = 0; i < 8; i++){
            System.out.printf(Integer.toString(result[i]));
        }
    }
}