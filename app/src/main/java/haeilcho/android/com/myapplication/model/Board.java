package haeilcho.android.com.myapplication.model;

import java.util.Random;


/**
 * Created by HaeilCho on 2017-11-25.
 */

public class Board {

    /**
     *  처음부터 세세하게 구현하려고하지말고 간단한거부터 구현하자!!!
     *  일단 누르면 번호들 다 뜨는거부터 구현하자
     */

    //데이터+상태(?)+비즈니스로직
    //데이터, 로직인건 알겠는데 상태?

    /**
     * 뷰나 컨트롤러에 묶이지않아, 많은 곳에서 재사용이 가능하다.
     */

    private int isEmpty = 0;

    private Cell[][] cells = new Cell[4][4];

    private GameState state;

    private enum GameState { IN_PROGRESS, FINISHED };

    private Compare compare = new Compare();

    public Board() {
        restart();
    }

    public void restart(){
        setCellNum();
        state = GameState.IN_PROGRESS;
    }

    public void setCellNum(){
        Cell[][] cell = new Cell[4][4];
        int randomArray[] = setArrayNum().clone();
        int num = 0;
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 4; j++){
                cell[i][j] = new Cell();
                cell[i][j].setNumValue(randomArray[num++]);
                System.out.println("cellTest "+ cell[i][j].getNumValue());
            }
        }
    }

    public int[] setArrayNum(){
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

    /**
     * 로직, 어떻게 처리해야하는지에 Model에 들어있네.
     * Model 폴더 안에 데이터도 따로 들어있고..
     */

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


    ///////////////////////////////////////////////////////////////////////////////////
    public void mark( int row, int col ) {

        if(isValid(row, col)) {
            if(cells[row][col].getOpenValue()==Open.X){
                cells[row][col].setOpenValue(Open.O);
//                if(isValueEmpty()){
//                    compare.compareEach();
//                }
            }
        }
    }

//    private boolean isCompareValueEmpty(){
//        if(compare.getFirstValue()!=isEmpty && compare.getSecondValue()!=isEmpty){
//            return true;
//        }else{
//            return false;
//        }
//    }


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
        return idx < 0 || idx > 4;
    }

    private boolean isCellValueAlreadySet(int row, int col) { //이미 설정이 된 상태이면
        return cells[row][col] != null;
    }

    private void openCellNum(){

    }


}
