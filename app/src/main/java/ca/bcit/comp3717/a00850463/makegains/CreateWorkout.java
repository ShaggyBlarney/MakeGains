package ca.bcit.comp3717.a00850463.makegains;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import ca.bcit.comp3717.a00850463.makegains.Workout.Exercise;
import ca.bcit.comp3717.a00850463.makegains.Workout.Workout;
import ca.bcit.comp3717.a00850463.makegains.dBAccess.Database;

public class CreateWorkout extends ListActivity {

    Database db;
    ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
    ArrayAdapter<Exercise> adapter;
    Workout workout;
    boolean create = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        Intent intent = getIntent();
        String idstr = intent.getStringExtra("id");
        if (idstr.equals("New Workout")) {
            workout = new Workout(idstr);
            create = true;
        } else {
            workout = Database.workoutDao.fetchWorkoutById(Integer.parseInt(idstr));
        }

        adapter = new ArrayAdapter<Exercise>(this, R.layout.exercise_edit_row, exerciseList);
        exerciseList.add(null);
        setListAdapter(adapter);

    }

    public void openSchedule(View v) {
        Intent intent = new Intent(this, Schedule.class);
        intent.putExtra("workout", "New Workout");
        startActivity(intent);
    }

}
