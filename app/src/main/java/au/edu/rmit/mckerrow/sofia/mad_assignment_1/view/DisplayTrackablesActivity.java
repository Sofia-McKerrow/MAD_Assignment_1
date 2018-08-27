package au.edu.rmit.mckerrow.sofia.mad_assignment_1.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.PlaneTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.sample.SampleTrackableProvider;

public class DisplayTrackablesActivity extends AppCompatActivity {

    List<PlaneTrackable> planeTrackableList = SampleTrackableProvider.trackableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trackables_list);

        TrackableAdapter adapter = new TrackableAdapter(this, planeTrackableList);
        // adapter.readTrackableFile(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvTrackables);
        recyclerView.setAdapter(adapter);

        // Log.i(LOG_TAG,"Test " + planeTrackableList.size());

        // TestTrackingService.test(this);
    }

}
