package ca.bcit.comp3717.a00850463.makegains.Workout;

import android.graphics.Color;

/**
 * Created by kearn on 2016-11-01.
 */

public class Stretch extends Exercise {
    private int duration;

    public Stretch() {
        super(0, "Stretch", Color.WHITE, "stretch");
        duration = 0;

    }

    public Stretch(String title, int id) {
        super(id, title, Color.WHITE, "balance");
        duration = 0;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
