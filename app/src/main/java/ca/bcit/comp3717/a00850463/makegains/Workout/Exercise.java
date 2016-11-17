package ca.bcit.comp3717.a00850463.makegains.Workout;

/**
 * Created by kearn on 2016-11-01.
 */

public abstract class Exercise {
    private int id;
    private String name;
    private int colorCode;
    private String type;

    public Exercise(int id, String name, int colorCode, String type) {
        this.id = id;
        this.name = name;
        this.colorCode = colorCode;
        this.type = type;
    }

    public Exercise(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Exercise() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
