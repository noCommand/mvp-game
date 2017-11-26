package haeilcho.android.com.myapplication.model;

import java.util.Random;

import static haeilcho.android.com.myapplication.model.Player.X;

/**
 * Created by HaeilCho on 2017-11-25.
 */

public class Board {
    //데이터+상태(?)+비즈니스로직
    //데이터, 로직인건 알겠는데 상태?

    /**
     * 뷰나 컨트롤러에 묶이지않아, 많은 곳에서 재사용이 가능하다.
     */


    private Cell[][] cells = new Cell[4][4];



    private Player winner;
    private GameState state;
    private Player currentTurn;

    private enum GameState { IN_PROGRESS, FINISHED };

    public Board() {
        setCellNum();
        //restart();
    }

    public void restart(){

        clearCells();
        winner = null;
        currentTurn = X;
        state = GameState.IN_PROGRESS;
    }

    public int[] setCellNum(){
        int cellNum[] = new int[16];
        int randomA[] = setRandomNum();
        int randomB[] = setRandomNum();

        for(int cellIndex = 0; cellIndex < 16; cellIndex++){
            if(cellIndex < 8) {
                cellNum[cellIndex] = randomA[cellIndex];
            }
            if(cellIndex >= 8){
                cellNum[cellIndex] = randomB[cellIndex-8];
            }
        }
        return cellNum;
    }

    public int[] setRandomNum(){
        int halfNum[] = new int[8];
        Random r = new Random();
        for(int i=0;i<=7;i++)
        {
            halfNum[i] = r.nextInt(8)+1;
            for(int j=0;j<i;j++)
            {
                if(halfNum[i]==halfNum[j])
                {
                    i--;
                }
            }
        }
        return halfNum;
    };

    public Player mark( int row, int col ) {

        Player playerThatMoved = null;

        if(isValid(row, col)) {

            cells[row][col].setValue(currentTurn);
            playerThatMoved = currentTurn;

            if(isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED;
                winner = currentTurn;

            } else {
                // flip the current turn and continue
                flipCurrentTurn();
            }
        }

        return playerThatMoved;
    }

    public Player getWinner() {
        return winner;
    }

    private void clearCells() { //셀 내용 초기화
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                cells[i][j] = new Cell();//----------->?
            }
        }
    }

    /**
     * 로직, 어떻게 처리해야하는지에 Model에 들어있네.
     * Model 폴더 안에 데이터도 따로 들어있고..
     */


    private boolean isValid(int row, int col ) {
        if( state == GameState.FINISHED ) { // 현 상태가 finished이면
            return false;
        } else if( isOutOfBounds(row) || isOutOfBounds(col) ) {
            return false;
        } else if( isCellValueAlreadySet(row, col) ) {
            return false;
        } else {
        }
        return true;
    }

    private boolean isOutOfBounds(int idx) {
        return idx < 0 || idx > 3;
    }

    private boolean isCellValueAlreadySet(int row, int col) { //이미 설정이 된 상태이면
        return cells[row][col].getValue() != null;
    }


    /**
     * Algorithm adapted from http://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html
     * @param player
     * @param currentRow
     * @param currentCol
     * @return true if <code>player</code> who just played the move at the <code>currentRow</code>, <code>currentCol</code>
     *              has a tic tac toe.
     */
    private boolean isWinningMoveByPlayer(Player player, int currentRow, int currentCol) {

        return (cells[currentRow][0].getValue() == player         // 3-in-the-row
                && cells[currentRow][1].getValue() == player
                && cells[currentRow][2].getValue() == player
                || cells[0][currentCol].getValue() == player      // 3-in-the-column
                && cells[1][currentCol].getValue() == player
                && cells[2][currentCol].getValue() == player
                || currentRow == currentCol            // 3-in-the-diagonal
                && cells[0][0].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][2].getValue() == player
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && cells[0][2].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][0].getValue() == player);
    }

    private void flipCurrentTurn() {
        currentTurn = currentTurn == X ? Player.O : X;
    }


}
