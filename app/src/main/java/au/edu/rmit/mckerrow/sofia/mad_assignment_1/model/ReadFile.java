package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;

public class ReadFile {

    public static List<BirdTrackable> trackableList = new ArrayList<>();
    public static Map<String, BirdTrackable> trackableMap = new HashMap<>();
    private static final String LOG_TAG = BirdTrackable.class.getName();

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

    public static List<BirdTrackable> getTrackableList() {
        return trackableList;
    }

    public static void setTrackableList(List<BirdTrackable> trackableList) {
        ReadFile.trackableList = trackableList;
    }

    public static Map<String, BirdTrackable> getTrackableMap() {
        return trackableMap;
    }

    public static void setTrackableMap(Map<String, BirdTrackable> trackableMap) {
        ReadFile.trackableMap = trackableMap;
    }
}
