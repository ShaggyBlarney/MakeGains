package ca.bcit.comp3717.a00850463.makegains;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.DatePicker;
import android.widget.Toast;

public class Schedule extends AppCompatActivity {
    private int year_, month_,day_;
    private final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        // Initialize the variables year month day
        final java.util.Calendar calendar = java.util.Calendar.getInstance();
        year_  = calendar.get(java.util.Calendar.YEAR);
        month_ = calendar.get(java.util.Calendar.MONTH);
        day_   = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        //Run the dialog
        showDialog(DIALOG_ID);

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID){
            return new DatePickerDialog(this,dpickerListener,year_,month_,day_);
        }
        return null;
    }

    //set the date and send a toast showing the date picked
    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_  = year;
            month_ = month;
            day_   =  dayOfMonth;
            Toast.makeText(Schedule.this, year_ + "/" + month_ + "/" + day_, Toast.LENGTH_SHORT).show();
        }
    };

}
