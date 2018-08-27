package au.edu.rmit.mckerrow.sofia.mad_assignment_1;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.PlaneTrackable;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = PlaneTrackable.class.getName();
    private Map<String, PlaneTrackable> trackableList = new HashMap<String, PlaneTrackable>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, "Test");

        readTrackableFile(this);
        for (Map.Entry<String, PlaneTrackable> entry : trackableList.entrySet()) {
            Log.i(LOG_TAG,"Trackable " + entry.getKey() + " : " + entry.getValue().toString());
        }
        // TestTrackingService.test(this);
    }

    private void readTrackableFile(Context context)
    {
        trackableList.clear();
        // resource reference to tracking_data.txt in res/raw/ folder of your project
        // supports trailing comments with //
        try (Scanner scanner = new Scanner(context.getResources().openRawResource(R.raw.food_truck_data)))
        {
            String [] values;

            while(scanner.hasNextLine())
            {
                values = scanner.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                String id = values[0];
                int trackableID = Integer.parseInt(id);
                String name = values[1];
                String description = values[2];
                String url = values[3];
                String category = values[4];

                PlaneTrackable trackableInfo = new PlaneTrackable(trackableID, name, description, url, category);
                trackableList.put(id, trackableInfo);
            }
            scanner.close();
        }
        catch (Resources.NotFoundException e)
        {
            Log.i(LOG_TAG, "File Not Found Exception Caught");
        }
    }
}
