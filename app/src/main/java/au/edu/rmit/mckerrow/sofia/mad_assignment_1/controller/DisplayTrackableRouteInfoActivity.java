package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.ReadFile;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackableInfo;

public class DisplayTrackableRouteInfoActivity extends AppCompatActivity {

    private static List<BirdTrackable> trackableList;
    private static Map<String, BirdTrackable> trackableMap;
    private TrackableInfo trackableInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trackable_route_info);

        // Check if a trackableInfo singleton has been created
        if (trackableInfo == null) {
            trackableInfo = TrackableInfo.getSingletonInstance(this);
        }

        trackableList = trackableInfo.getTrackableList();
        trackableMap = trackableInfo.getTrackableMap();

        String trackableID = getIntent().getExtras().getString(TrackableAdapter.TRACKABLE_ID_KEY);
        BirdTrackable birdTrackable = trackableMap.get(trackableID);
        Toast.makeText(this, "Received item " + birdTrackable.getName(), Toast.LENGTH_SHORT).show();

    }
}
