package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;

public class DisplayTrackablesActivity extends AppCompatActivity {

    // List<BirdTrackable> planeTrackableList = SampleTrackableProvider.trackableList;
    public static List<BirdTrackable> trackableList = new ArrayList<>();
    public static Map<String, BirdTrackable> trackableMap = new HashMap<>();
    private static final String LOG_TAG = BirdTrackable.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trackables_list);

        readTrackableFile(this);

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

        // Log.i(LOG_TAG,"Test " + planeTrackableList.size());

        // TestTrackingService.test(this);
    }

    // Read file with trackable data - food_truck_data.txt
    public static void readTrackableFile(Context context) {
        if (trackableMap != null) {
            trackableMap.clear();
        }

        // resource reference to tracking_data.txt in res/raw/ folder of your project
        // supports trailing comments with //

        try (Scanner scanner = new Scanner(context.getResources().openRawResource(R.raw.bird_data))) {
            String[] values;

            while (scanner.hasNextLine()) {
                // values = scanner.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                int trackableID = 0;
                String id = null;
                String name = null;
                String description = null;
                String url = null;
                String category = null;
                String image = null;

                // Check if next token is an int
                if (scanner.hasNextInt()) {
                    trackableID = scanner.nextInt();
                }
                // If next token isn't an int
                else {
                    values = scanner.nextLine().split("\"(,\")*");
                    id = values[0];
                    // int trackableID = Integer.parseInt(id);
                    name = values[1];
                    description = values[2];
                    url = values[3];
                    category = values[4];
                    image = values[5];
                }

                BirdTrackable trackableInfo = new BirdTrackable(trackableID, name, description, url, category, image);
                trackableList.add(trackableInfo);
                trackableMap.put(id, trackableInfo);
            }
        } catch (Resources.NotFoundException e) {
            Log.i(LOG_TAG, "File Not Found Exception Caught");
        }
    }
}
