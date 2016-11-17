package ca.bcit.comp3717.a00850463.makegains.dBAccess;

/**
 * Created by kearn on 2016-11-02.
 */

public interface WorkoutSchema {
    String WORKOUT_TABLE = "workouts";
    String COL_ID = "_id";
    String COL_TITLE = "title";
    String COL_COLOR = "color";
    String COL_DATE = "create_date";
    String WORKOUT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + WORKOUT_TABLE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TITLE + " TEXT NOT NULL, "
            + COL_COLOR + " INTEGER, "
            + COL_DATE + " BIGINT "
            + ")";
    String[] WORKOUT_COL = new String[] { COL_ID, COL_TITLE, COL_COLOR, COL_DATE};
}
