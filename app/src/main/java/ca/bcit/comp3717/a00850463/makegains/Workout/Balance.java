package ca.bcit.comp3717.a00850463.makegains.Workout;

import android.graphics.Color;

/**
 * Created by kearn on 2016-11-01.
 */

public class Balance extends Exercise {
    private int duration, sets;

    public Balance() {
        super(0, "Balance", Color.WHITE, "balance");
        duration = 0;
        sets = 0;
    }


    public Balance(int id, String title) {
        super(id, title, Color.WHITE, "balance");
        duration = 0;
        sets = 0;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
