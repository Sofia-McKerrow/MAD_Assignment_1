package au.edu.rmit.mckerrow.sofia.mad_assignment_1.sample;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.PlaneTrackable;

public class SampleTrackableProvider {

    public static List<PlaneTrackable> trackableList;
    public static Map<String, PlaneTrackable> trackableMap;

    static {
        trackableList = new ArrayList<>();
        trackableMap = new HashMap<>();

        addItem(new PlaneTrackable(1, "Qantas Airways", "Flag carrier of Australia", "www.qantas.com", "Australia"));
        addItem(new PlaneTrackable(2, "Virgin Australia", "Australian low-cost airline", "www.jetstar.com", "Australia"));
        addItem(new PlaneTrackable(3, "Jetstar", "Flag carrier of Australia", "www.qantas.com.au", "Australia"));
        addItem(new PlaneTrackable(4, "Air Asia", "Malaysian low-cost airline", "www.airasia.com", "Asia"));
        addItem(new PlaneTrackable(5, "Singapore Airlines", "Flag carrier of Singapore", "www.singaporeair.com", "Asia"));
        addItem(new PlaneTrackable(6, "Emirates", "Airline based in Duabi, United Arab Emirates", "www.emirates.com",
                "Middle East"));
        addItem(new PlaneTrackable(7, "Qatar Airways", "Flag carrier of Qatar", "www.qatarairways.com", "Middle East"));
        addItem(new PlaneTrackable(8, "British Airways", "Flag carrier of the United Kingdom", "www.britishairways.com",
                "Britian"));
        addItem(new PlaneTrackable(9, "United Airlines", "Major United States airline", "www.united.com", "United States"));
        addItem(new PlaneTrackable(10, "American Airlines", "Major United States airline", "www.aa.com", "United States"));
    }

    private static void addItem(PlaneTrackable trackable) {
        trackableList.add(trackable);
        trackableMap.put(Integer.toString(trackable.getTrackableID()), trackable);
    }
}
