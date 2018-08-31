package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackableInfo;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.service.TestTrackingService;

public class DisplayTrackablesActivity extends AppCompatActivity {

    private static List<BirdTrackable> trackableList;
    private static Map<String, BirdTrackable> trackableMap;
    private TrackableInfo trackableInfo;
    private static TrackableAdapter adapter;

    private static final String LOG_TAG = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trackables_list);

//        // Check if a trackableInfo singleton has been created
        if (trackableInfo == null) {
            trackableInfo = TrackableInfo.getSingletonInstance(this);
        }

        trackableList = trackableInfo.getTrackableList();
        trackableMap = trackableInfo.getTrackableMap();

        // Sort list alphabetically
        Collections.sort(trackableList, new Comparator<BirdTrackable>() {
            @Override
            public int compare(BirdTrackable o1, BirdTrackable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        adapter = new TrackableAdapter(this, trackableList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvTrackables);
        recyclerView.setAdapter(adapter);

        setUpSpinner();

        // TestTrackingService.test(this);
    }

    // Set category names in spinner
    private void setUpSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.filterSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.categories,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        // Stop onItemSelected() in FilterController from being initialised when the app is first started
        spinner.setSelected(false);
        spinner.setSelection(0, true);

        spinner.setOnItemSelectedListener(new FilterController(this));
    }

    public static TrackableAdapter getAdapter() {
        return adapter;
    }

}
