package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTracking;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackingInfo;

public class DisplayTrackingsListActivity extends AppCompatActivity {
    private static List<BirdTracking> trackingList;
    private TrackingInfo trackingInfo;
    private static TrackingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackings_list);

        trackingList = new ArrayList<BirdTracking>();
        trackingList.add(new BirdTracking("tracking1", "1", "Lunch with magpie, Jells Park",
                "05/07/2018 1:05:00 PM", "05/07/2018 1:10:00 PM", "05/07/2018 1:05:00", "-37.817987, 144.956944",
                "-37.820666, 144.958277"));

        // Check if a trackableInfo singleton has been created
        if (trackingInfo == null) {
            trackingInfo = TrackingInfo.getSingletonInstance(this);
        }

        trackingInfo.setTrackingList(trackingList);

        adapter = new TrackingAdapter(this, trackingList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvTrackings);
        recyclerView.setAdapter(adapter);
    }
}
