package ca.bcit.comp3717.a00850463.makegains.dBAccess;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kearn on 2016-11-03.
 */

public class Database {
    private static final String TAG = "dB_";
    private static final String DB_NAME = "MakeGains";
    private DatabaseHelper dBHelper;
    // Increment Version on schema change
    private static final int DB_VERSION = 1;
    private final Context context;
    public static WorkoutDao workoutDao;
    public static ExerciseDao exerciseDao;

    public Database open() throws SQLException {
        dBHelper = new DatabaseHelper(context);
        SQLiteDatabase dB = dBHelper.getWritableDatabase();
        workoutDao = new WorkoutDao(dB);
        exerciseDao = new ExerciseDao(dB);
        return this;
    }

    public void close() {
        dBHelper.close();
    }

    public Database(Context context) {
        this.context = context;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dB) {
            dB.execSQL(WorkoutSchema.WORKOUT_TABLE_CREATE);
            dB.execSQL(ExerciseSchema.EXERCISE_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase dB, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + " which distroys all old data.");
            dB.execSQL("DROP TABLE IF EXISTS " + WorkoutSchema.WORKOUT_TABLE);
            dB.execSQL("DROP TABLE IF EXISTS " + ExerciseSchema.EXERCISE_TABLE);
            onCreate(dB);
        }
    }
}
