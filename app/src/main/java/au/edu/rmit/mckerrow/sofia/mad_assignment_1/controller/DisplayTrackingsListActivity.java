package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTracking;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackingInfo;

public class DisplayTrackingsListActivity extends AppCompatActivity {
    private static List<BirdTracking> trackingList;
    private TrackingInfo trackingInfo;
    private static TrackingAdapter adapter;
    private Button addTracking;

    private static final String LOG_TAG = "DisplayTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackings_list);

        // Check if a trackableInfo singleton has been created
        if (trackingInfo == null) {
            trackingInfo = TrackingInfo.getSingletonInstance(this);
        }

        trackingList = trackingInfo.getTrackingList();

        if (trackingList == null) {
            trackingList = new ArrayList<BirdTracking>();
        }
        for (int i = 0; i < trackingList.size(); i++) {
            Log.i(LOG_TAG, "Tracking List " + trackingList.get(i).toString());
        }

        adapter = new TrackingAdapter(this, trackingList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvTrackings);
        recyclerView.setAdapter(adapter);

        addTracking = (Button) findViewById(R.id.addTracking);
        addTracking.setOnClickListener(new AddTrackingButtonController(this));
    }

    public static TrackingAdapter getAdapter() {
        return adapter;
    }
}
