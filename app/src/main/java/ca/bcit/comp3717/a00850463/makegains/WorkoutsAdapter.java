package ca.bcit.comp3717.a00850463.makegains;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ca.bcit.comp3717.a00850463.makegains.Workout.Workout;

/**
 * Created by kearn on 2016-11-02.
 */

public class WorkoutsAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<Workout> workoutList = new ArrayList<Workout>();
    private Context context;

    public WorkoutsAdapter(ArrayList<Workout> workoutList, Context context) {
        this.workoutList = workoutList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return workoutList.size();
    }

    @Override
    public Workout getItem(int i) {
        return workoutList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return workoutList.get(i).getId();
    }

    @Override
    public View getView(final int pos, View cView, ViewGroup parent) {
        View view = cView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.workout_row, null);
        }

        TextView workoutTitle = (TextView)view.findViewById(R.id.workoutTitle);
        workoutTitle.setText((CharSequence) workoutList.get(pos).getTitle());

        Button playBtn = (Button)view.findViewById(R.id.playWorkout);
        Button editBtn = (Button)view.findViewById(R.id.editWorkout);
        playBtn.setTag(workoutList.get(pos).getId());
        editBtn.setTag(workoutList.get(pos).getId());

        return view;
    }
}
