package haeilcho.android.com.myapplication.model;

/**
 * Created by HaeilCho on 2017-11-27.
 */

public class Compare {

    public int firstValue = 0;

    public int secondValue = 0;

    public void setFirstValue(int firstValue){
        this.firstValue = firstValue;
    }

    public void setSecondValue(int secondValue){
        this.secondValue = secondValue;
    }

    public int getFirstValue(){
        return firstValue;
    }

    public int getSecondValue(){
        return secondValue;
    }

    public boolean compareEach(){
        if(firstValue==secondValue){
            return true;
        } else {
            return false;
        }
    }

}
