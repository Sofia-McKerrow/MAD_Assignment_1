package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

import java.util.Date;

public class PlaneLandingEvent extends AbstractTracking implements Tracking {


    public PlaneLandingEvent(String trackingID, String trackableID, String title, Date startTime, Date finishTime,
                             Date meetTime, String currentLocation, String meetLocation) {
        super(trackingID, trackableID, title, startTime, finishTime, meetTime, currentLocation, meetLocation);
    }
}
