package ca.bcit.comp3717.a00850463.makegains.dBAccess;

/**
 * Created by kearn on 2016-11-02.
 */

public interface ExerciseSchema {
    String EXERCISE_TABLE = "exercises";
    String COL_ID = "_id";
    String COL_WORKOUT = "workout_id";
    String COL_TITLE = "title";
    String COL_COLOR = "color";
    String COL_DATE = "create_date";
    String COL_REPS = "reps";
    String COL_SETS = "sets";
    String COL_DURATION = "duration";
    String COL_RESISTANCE = "resistance";
    String COL_TYPE = "type";
    String EXERCISE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + EXERCISE_TABLE + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_WORKOUT + " INTEGER, "
            + COL_TITLE + " TEXT NOT NULL, "
            + COL_COLOR + " INTEGER, "
            + COL_DATE + " BIGINT, "
            + COL_REPS + " INTEGER, "
            + COL_SETS + " INTEGER, "
            + COL_DURATION + " INTEGER, "
            + COL_RESISTANCE + " INTEGER, "
            + COL_TYPE + " TEXT"
            + ")";
    String[] EXERCISE_COL = new String[] { COL_ID, COL_WORKOUT, COL_TITLE, COL_COLOR, COL_DATE, COL_REPS, COL_SETS, COL_DURATION, COL_RESISTANCE, COL_TYPE};
}
