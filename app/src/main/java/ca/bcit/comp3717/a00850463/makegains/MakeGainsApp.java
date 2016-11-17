package ca.bcit.comp3717.a00850463.makegains;

import android.app.Application;

import ca.bcit.comp3717.a00850463.makegains.dBAccess.Database;

/**
 * Created by kearn on 2016-11-03.
 */

public class MakeGainsApp extends Application {
    public static final String TAG = MakeGainsApp.class.getSimpleName();
    public static Database dB;

    @Override
    public void onCreate(){
        super.onCreate();
        dB = new Database(this);
        dB.open();
    }

    @Override
    public void onTerminate() {
        dB.close();
        super.onTerminate();
    }
}
