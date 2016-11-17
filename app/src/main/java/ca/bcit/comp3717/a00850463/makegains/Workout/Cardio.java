package ca.bcit.comp3717.a00850463.makegains.Workout;

import android.graphics.Color;

/**
 * Created by kearn on 2016-11-01.
 *
 *  Cardio is-an Exercise class
 */

public class Cardio extends Exercise {
    private int duration;
    private int resistance;

    public Cardio(int id, String title) {
        super(id, title, Color.WHITE, "cardio");
        duration = 0;
        resistance = 0;

    }

    public Cardio () {
        super(0, "Cardio", Color.WHITE, "cardio");
        duration = 0;
        resistance = 0;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int durationSeconds) {
        this.duration = durationSeconds;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
}
