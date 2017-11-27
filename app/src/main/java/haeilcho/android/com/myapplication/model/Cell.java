package haeilcho.android.com.myapplication.model;

/**
 * Created by HaeilCho on 2017-11-25.
 */

public class Cell {

    private Open value;

    public Cell(){
        value = Open.X;
    }

    public Open getValue() {
        return value;
    }

    public void setValue(Open value) {
        this.value = value;
    }
}
