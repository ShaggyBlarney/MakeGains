package ca.bcit.comp3717.a00850463.makegains;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import ca.bcit.comp3717.a00850463.makegains.Workout.Workout;
import ca.bcit.comp3717.a00850463.makegains.dBAccess.Database;

import static ca.bcit.comp3717.a00850463.makegains.MakeGainsApp.dB;

public class WorkOutList extends ListActivity {

    private ArrayList<Workout> workouts =  new ArrayList<Workout>();
    private ArrayAdapter<Workout> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_list);

        workouts.addAll(Database.workoutDao.fetchAllWorkouts());

        adapter = new ArrayAdapter<Workout>(this, R.layout.workout_row, R.id.workoutTitle, workouts);
        setListAdapter(adapter);
    }

    // onClick func for FAB
    public void createNewWorkout(View view) {
        Intent intent = new Intent(this, CreateWorkout.class);
        intent.putExtra("id", "New Workout");
        startActivity(intent);
    }

    public void playWorkout(View v) {
       /* Intent intent = new Intent(this, PlayWorkout.class);
        intent.putExtra("id", (int)v.getTag());
        startActivity(intent);*/
        String id = "" + v.getTag();

        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }

    public void editWorkout(View v) {
        Intent intent = new Intent(this, CreateWorkout.class);
        intent.putExtra("id", (int)v.getTag());
        startActivity(intent);
    }
}
