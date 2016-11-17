package ca.bcit.comp3717.a00850463.makegains.dBAccess;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.comp3717.a00850463.makegains.Workout.Workout;

/**
 * Created by kearn on 2016-11-02.
 */

public class WorkoutDao extends DbContentProvider implements WorkoutSchema {

    private Cursor cursor;
    private ContentValues initialValues;

    public WorkoutDao (SQLiteDatabase dB) {
        super(dB);
    }

    public Workout fetchWorkoutById(int id) {
        final String selectionArgs[] = {String.valueOf(id)};
        final String selection = id + " =?";
        Workout workout = new Workout("");
        cursor = super.query(WORKOUT_TABLE, WORKOUT_COL, selection, selectionArgs, COL_ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                workout = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return workout;
    }

    public List<Workout> fetchAllWorkouts() {
        List<Workout> workoutList = new ArrayList<Workout>();
        cursor = super.query(WORKOUT_TABLE, WORKOUT_COL, null, null, COL_ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Workout workout = cursorToEntity(cursor);
                workoutList.add(workout);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return workoutList;
    }

    public boolean addWorkout(Workout workout) {
        setContentValue(workout);
        try {
            return super.insert(WORKOUT_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException e) {
            Log.w("Database", e.getMessage());
            return false;
        }
    }

    protected  Workout cursorToEntity(Cursor cursor) {
        Workout workout = new Workout("");

        int idI, titleI, colorCodeI;

        if (cursor != null) {
            if(cursor.getColumnIndex(COL_ID) != -1) {
                idI = cursor.getColumnIndexOrThrow(COL_ID);
                workout.setId(cursor.getInt(idI));
            }


            if(cursor.getColumnIndex(COL_TITLE) != -1) {
                titleI = cursor.getColumnIndexOrThrow(COL_TITLE);
                workout.setTitle(cursor.getString(titleI));
            }

            if(cursor.getColumnIndex(COL_COLOR) != -1) {
                colorCodeI = cursor.getColumnIndexOrThrow(COL_COLOR);
                workout.setColorCode(cursor.getInt(colorCodeI));
            }
        }
        return workout;
    }

    private void setContentValue(Workout workout) {
        initialValues = new ContentValues();
        initialValues.put(COL_ID, workout.getId());
        initialValues.put(COL_TITLE, workout.getTitle());
        initialValues.put(COL_COLOR, workout.getColorCode());
    }

    private  ContentValues getContentValue() {
        return initialValues;
    }
}
