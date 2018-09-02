package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;

public class AddEditTrackingActivity extends AppCompatActivity {
    private Button saveTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit_tracking);

        saveTracking = (Button) findViewById(R.id.saveTracking);
        saveTracking.setOnClickListener(new SaveTrackingButtonController(this, this));
    }
}
