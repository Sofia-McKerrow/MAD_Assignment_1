package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TrackableInfo {

    private static TrackableInfo trackableInfo;
    private static Context mContext;
    private List<BirdTrackable> trackableList;
    private Map<String, BirdTrackable> trackableMap;
    private static final List<BirdTrackable> FINAL_TRACKABLE_LIST;

    static {
        List trackables = new ArrayList<BirdTrackable>();
        trackables = ReadFile.getTrackableList();

        FINAL_TRACKABLE_LIST = Collections.unmodifiableList(trackables);
    }

    // Constructor for singleton
    private TrackableInfo() {
        // Read data from bird_data.txt
        ReadFile.readTrackableFile(mContext);
        trackableList = ReadFile.getTrackableList();
        trackableMap = ReadFile.getTrackableMap();
    }

    private static class TrackableLazyHolder {
        static final TrackableInfo INSTANCE = new TrackableInfo();
    }

    // Initialise singleton
    public static TrackableInfo getSingletonInstance(Context context) {
        mContext = context;
        return TrackableLazyHolder.INSTANCE;
    }

    public static TrackableInfo getTrackableInfo() {
        // Check if a singleton object has been created
        if (trackableInfo == null) {
            trackableInfo = new TrackableInfo();
        }
        return trackableInfo;
    }

    public List<BirdTrackable> getTrackableList() {
        return trackableList;
    }

    public void setTrackableList(List<BirdTrackable> trackableList) {
        this.trackableList = trackableList;
    }

    public Map<String, BirdTrackable> getTrackableMap() {
        return trackableMap;
    }

    public void setTrackableMap(Map<String, BirdTrackable> trackableMap) {
        this.trackableMap = trackableMap;
    }

    public static List<BirdTrackable> getFINAL_TRACKABLE_LIST() {
        return FINAL_TRACKABLE_LIST;
    }
}
