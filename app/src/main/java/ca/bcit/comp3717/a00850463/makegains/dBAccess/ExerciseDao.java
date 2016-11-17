package ca.bcit.comp3717.a00850463.makegains.dBAccess;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.comp3717.a00850463.makegains.Workout.Balance;
import ca.bcit.comp3717.a00850463.makegains.Workout.Cardio;
import ca.bcit.comp3717.a00850463.makegains.Workout.Strength;
import ca.bcit.comp3717.a00850463.makegains.Workout.Stretch;
import ca.bcit.comp3717.a00850463.makegains.Workout.Workout;
import ca.bcit.comp3717.a00850463.makegains.Workout.Exercise;


/**
 * Created by kearn on 2016-11-02.
 */

public class ExerciseDao extends DbContentProvider implements ExerciseSchema {

    private Cursor cursor;
    private ContentValues initialValues;

    public ExerciseDao (SQLiteDatabase dB) {
        super(dB);
    }

    public Exercise fetchExerciseById(int id) {
        final String selectionArgs[] = {String.valueOf(id)};
        final String selection = id + " =?";
        Exercise exercise = null;
        cursor = super.query(EXERCISE_TABLE, EXERCISE_COL, selection, selectionArgs, COL_ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                exercise = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return exercise;
    }

    public List<Exercise> fetchAllExercises() {
        List<Exercise> exerciseList = new ArrayList<Exercise>();
        cursor = super.query(EXERCISE_TABLE, EXERCISE_COL, null, null, COL_ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Exercise exercise = cursorToEntity(cursor);
                exerciseList.add(exercise);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return exerciseList;
    }

    public List<Exercise> fetchAllWorkoutExercises(int workoutId) {
        List<Exercise> exerciseList = new ArrayList<Exercise>();
        cursor = super.query(EXERCISE_TABLE, EXERCISE_COL, COL_WORKOUT + " = " + workoutId, null, COL_ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Exercise exercise = cursorToEntity(cursor);
                exerciseList.add(exercise);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return exerciseList;
    }

    public boolean addExercise(Exercise exercise) {
        setContentValue(exercise);
        try {
            return super.insert(EXERCISE_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException e) {
            Log.w("Database", e.getMessage());
            return false;
        }
    }

    protected  Exercise cursorToEntity(Cursor cursor) {
        Exercise exercise = null;
        String type = null;
        int idI, titleI, colorCodeI, typeI, repsI, setsI, durationI, resistanceI;

        if (cursor != null) {
            if(cursor.getColumnIndex(COL_TYPE) != -1) {
                typeI = cursor.getColumnIndexOrThrow(COL_TYPE);
                type = cursor.getString(typeI);
                exercise = getExerciseType(type);
                exercise.setType(type);
            }

            if(cursor.getColumnIndex(COL_ID) != -1) {
                idI = cursor.getColumnIndexOrThrow(COL_ID);
                exercise.setId(cursor.getInt(idI));
            }


            if(cursor.getColumnIndex(COL_TITLE) != -1) {
                titleI = cursor.getColumnIndexOrThrow(COL_TITLE);
                exercise.setName(cursor.getString(titleI));
            }

            if(cursor.getColumnIndex(COL_COLOR) != -1) {
                colorCodeI = cursor.getColumnIndexOrThrow(COL_COLOR);
                exercise.setColorCode(cursor.getInt(colorCodeI));
            }

            if (type != null) {
                switch(type) {
                    case "stretch":
                        if(cursor.getColumnIndex(COL_DURATION) != -1) {
                            durationI = cursor.getColumnIndexOrThrow(COL_DURATION);
                            ((Stretch) exercise).setDuration(cursor.getInt(durationI));
                        }
                        break;
                    case "balance":
                        if(cursor.getColumnIndex(COL_DURATION) != -1) {
                            durationI = cursor.getColumnIndexOrThrow(COL_DURATION);
                            ((Balance) exercise).setDuration(cursor.getInt(durationI));
                        }
                        if(cursor.getColumnIndex(COL_SETS) != -1) {
                            setsI = cursor.getColumnIndexOrThrow(COL_SETS);
                            ((Balance) exercise).setSets(cursor.getInt(setsI));
                        }
                        break;
                    case "cardio":
                        if(cursor.getColumnIndex(COL_DURATION) != -1) {
                            durationI = cursor.getColumnIndexOrThrow(COL_DURATION);
                            ((Cardio) exercise).setDuration(cursor.getInt(durationI));
                        }
                        if(cursor.getColumnIndex(COL_RESISTANCE) != -1) {
                            setsI = cursor.getColumnIndexOrThrow(COL_RESISTANCE);
                            ((Cardio) exercise).setResistance(cursor.getInt(setsI));
                        }
                        break;
                    case "strength":
                        if(cursor.getColumnIndex(COL_REPS) != -1) {
                            repsI = cursor.getColumnIndexOrThrow(COL_REPS);
                            ((Strength) exercise).setReps(cursor.getInt(repsI));
                        }
                        if(cursor.getColumnIndex(COL_SETS) != -1) {
                            setsI = cursor.getColumnIndexOrThrow(COL_SETS);
                            ((Strength) exercise).setSets(cursor.getInt(setsI));
                        }
                        if(cursor.getColumnIndex(COL_RESISTANCE) != -1) {
                            setsI = cursor.getColumnIndexOrThrow(COL_RESISTANCE);
                            ((Strength) exercise).setResistance(cursor.getInt(setsI));
                        }
                        break;
                    default:
                }
            }
        }
        return exercise;
    }

    private void setContentValue(Exercise exercise) {
        initialValues = new ContentValues();
        initialValues.put(COL_ID, exercise.getId());
        initialValues.put(COL_TITLE, exercise.getName());
        initialValues.put(COL_COLOR, exercise.getColorCode());
        initialValues.put(COL_TYPE, exercise.getType());
            switch(exercise.getType()) {
                case "stretch":
                    initialValues.put(COL_DURATION, ((Stretch) exercise).getDuration());
                    break;
                case "balance":
                    initialValues.put(COL_DURATION, ((Balance) exercise).getDuration());
                    initialValues.put(COL_SETS, ((Balance) exercise).getSets());
                    break;
                case "cardio":
                    initialValues.put(COL_DURATION, ((Cardio) exercise).getDuration());
                    initialValues.put(COL_RESISTANCE, ((Cardio) exercise).getResistance());
                    break;
                case "strength":
                    initialValues.put(COL_REPS, ((Strength) exercise).getReps());
                    initialValues.put(COL_SETS, ((Strength) exercise).getSets());
                    initialValues.put(COL_RESISTANCE, ((Strength) exercise).getResistance());
                    break;
                default:
            }

    }

    private  ContentValues getContentValue() {
        return initialValues;
    }

    private Exercise getExerciseType(String type) {
        switch (type) {
            case "cardio":
                return new Cardio();
            case "strength":
                return new Strength();
            case "stretch":
                return new Stretch();
            case "balance":
                return new Balance();
            default:
                return null;
        }
    }
}
