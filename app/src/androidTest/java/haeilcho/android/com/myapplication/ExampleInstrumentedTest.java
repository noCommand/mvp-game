package haeilcho.android.com.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import haeilcho.android.com.myapplication.model.Board;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private Board board;

    @Test
    public void test(){
        int result[] = new int[16];
        for(int i = 0; i < 16; i++){
            result[i] = board.setCellNum()[i];
        }
    }

//    @Test
//    public void useAppContext() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("haeilcho.android.com.myapplication", appContext.getPackageName());
//    }
}
