package ca.bcit.comp3717.a00850463.makegains.Workout;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by kearn on 2016-11-01.
 */

public class Workout {
    private int id;
    private String title;
    private int colorCode;
    //private String schedule;
    private ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();

    public Workout(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public Workout(String title) {
        this.title = title;
        this.id = 0;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addExercise(Exercise exercise) {
        exerciseList.add(exercise);
    }

    public ArrayList<Exercise> getAllExercises() {
        return exerciseList;
    }

    public String toString() {
        return title;
    }
}
