package ca.bcit.comp3717.a00850463.makegains.Workout;

import android.graphics.Color;

/**
 * Created by kearn on 2016-11-01.
 */

public class Strength extends Exercise {
    private int reps, sets, resistance;

    public Strength () {
        super(0, "Strength", Color.WHITE, "strength");
        reps = 0;
        sets = 0;
        resistance = 0;

    }

    public Strength(String title, int id) {
        super(id, title, Color.WHITE, "strength");
        reps = 0;
        sets = 0;
        resistance = 0;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
}
