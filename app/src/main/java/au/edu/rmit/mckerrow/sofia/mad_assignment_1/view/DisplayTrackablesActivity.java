package au.edu.rmit.mckerrow.sofia.mad_assignment_1.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.PlaneTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.sample.SampleTrackableProvider;

public class DisplayTrackablesActivity extends AppCompatActivity {

    // List<PlaneTrackable> planeTrackableList = SampleTrackableProvider.trackableList;
    public static List<PlaneTrackable> trackableList = new ArrayList<>();
    public static Map<String, PlaneTrackable> trackableMap = new HashMap<>();
    private static final String LOG_TAG = PlaneTrackable.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trackables_list);

        readTrackableFile(this);
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

        try (Scanner scanner = new Scanner(context.getResources().openRawResource(R.raw.food_truck_data))) {
            String[] values;

            while (scanner.hasNextLine()) {
                values = scanner.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                String id = values[0];
                int trackableID = Integer.parseInt(id);
                String name = values[1];
                String description = values[2];
                String url = values[3];
                String category = values[4];

                PlaneTrackable trackableInfo = new PlaneTrackable(trackableID, name, description, url, category);
                trackableList.add(trackableInfo);
                trackableMap.put(id, trackableInfo);
            }
        } catch (Resources.NotFoundException e) {
            Log.i(LOG_TAG, "File Not Found Exception Caught");
        }
    }
}
