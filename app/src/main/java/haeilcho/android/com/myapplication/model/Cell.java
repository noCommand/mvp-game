package haeilcho.android.com.myapplication.model;

/**
 * Created by HaeilCho on 2017-11-25.
 */

public class Cell {

    private Open openValue;

    private int numValue;

    public Cell(){
        openValue = Open.X;
    }

    public Open getOpenValue() {
        return openValue;
    }

    public void setOpenValue(Open openValue) {
        this.openValue = openValue;
    }

    public int getNumValue(){ return numValue;}

    public void setNumValue(int numValue){ this.numValue = numValue;}
}
