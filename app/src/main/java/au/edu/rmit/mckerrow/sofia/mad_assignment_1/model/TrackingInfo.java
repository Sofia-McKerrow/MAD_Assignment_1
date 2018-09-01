package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

import android.content.Context;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.util.Calendar.PM;

public class TrackingInfo {

    private static TrackingInfo trackingInfo;
    private static Context mContext;
    private List<BirdTracking> trackingList;

    // Constructor for singleton
    private TrackingInfo() {

    }

    private static class TrackingLazyHolder {
        static final TrackingInfo INSTANCE = new TrackingInfo();
    }

    // Initialise singleton
    public static TrackingInfo getSingletonInstance(Context context) {
        mContext = context;
        return TrackingLazyHolder.INSTANCE;
    }

    public static TrackingInfo getTrackableInfo() {
        // Check if a singleton object has been created
        if (trackingInfo == null) {
            trackingInfo = new TrackingInfo();
        }
        return trackingInfo;
    }

    public List<BirdTracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(List<BirdTracking> trackingList) {
        this.trackingList = trackingList;
    }

    public List<BirdTracking> initialiseTrackingList() {
        trackingList = new ArrayList<BirdTracking>();
        trackingList.add(new BirdTracking("tracking1", "1", "Lunch with magpie, Jells Park",
                "05/07/2018 1:05:00 PM", "05/07/2018 1:10:00 PM", "05/07/2018 1:05:00", "-37.817987, 144.956944",
                "-37.820666, 144.958277"));

        return trackingList;
    }


}
