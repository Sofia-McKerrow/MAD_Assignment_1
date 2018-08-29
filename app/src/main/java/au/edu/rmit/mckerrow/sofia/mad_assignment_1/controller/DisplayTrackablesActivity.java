package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.ReadFile;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackableInfo;

public class DisplayTrackablesActivity extends AppCompatActivity {

    private static List<BirdTrackable> trackableList;
    private static Map<String, BirdTrackable> trackableMap;
    private TrackableInfo trackableInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trackables_list);

        // Check if a trackableInfo singleton has been created
        if (trackableInfo == null) {
            trackableInfo = TrackableInfo.getSingletonInstance(this);
        }

        trackableList = trackableInfo.getTrackableList();
        trackableMap = trackableInfo.getTrackableMap();

        for (int i = 0; i < trackableList.size(); i++) {
            Log.i("listTag", trackableList.get(i).toString());
        }

        for (Map.Entry<String, BirdTrackable> entry : trackableMap.entrySet()) {
            Log.i("myTag", entry.getKey()+ " : " + entry.getValue().toString());
        }

        // Sort list alphabetically
        Collections.sort(trackableList, new Comparator<BirdTrackable>() {
            @Override
            public int compare(BirdTrackable o1, BirdTrackable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        TrackableAdapter adapter = new TrackableAdapter(this, trackableList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvTrackables);
        recyclerView.setAdapter(adapter);

        // TestTrackingService.test(this);
    }

}