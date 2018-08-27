package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;

public class PlaneTrackable extends AbstractTrackable implements Trackable {

//    public static List<PlaneTrackable> trackableList;
//    public static Map<String, PlaneTrackable> trackableMap;
//    private static final String LOG_TAG = PlaneTrackable.class.getName();
//    private static Context mContext;

    public PlaneTrackable(int trackableID, String name, String description, String url, String category) {
        super(trackableID, name, description, url, category);
    }

//    // Read file with trackable data - food_truck_data.txt
//    public static void readTrackableFile(Context context) {
//        trackableMap.clear();
//        // resource reference to tracking_data.txt in res/raw/ folder of your project
//        // supports trailing comments with //
//
//        try (Scanner scanner = new Scanner(context.getResources().openRawResource(R.raw.food_truck_data))) {
//            String[] values;
//
//            while (scanner.hasNextLine()) {
//                values = scanner.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//                String id = values[0];
//                int trackableID = Integer.parseInt(id);
//                String name = values[1];
//                String description = values[2];
//                String url = values[3];
//                String category = values[4];
//
//                PlaneTrackable trackableInfo = new PlaneTrackable(trackableID, name, description, url, category);
//                trackableList.add(trackableInfo);
//                trackableMap.put(id, trackableInfo);
//            }
//
//        } catch (Resources.NotFoundException e) {
//            Log.i(LOG_TAG, "File Not Found Exception Caught");
//        }
//    }

}
