package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;

public abstract class AbstractTracking implements Tracking {

    private String trackingID;
    private String trackableID;
    private String title;
    private Date startTime;
    private Date finishTime;
    private Date meetTime;
    private String currentLocation;
    private String meetLocation;

    public AbstractTracking(String trackingID, String trackableID, String title, Date startTime, Date finishTime,
                            Date meetTime, String currentLocation, String meetLocation) {
        this.trackingID = trackingID;
        this.trackableID = trackableID;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.meetTime = meetTime;
        this.currentLocation = currentLocation;
        this.meetLocation = meetLocation;
    }

    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public String getTrackableID() {
        return trackableID;
    }

    public void setTrackableID(String trackableID) {
        this.trackableID = trackableID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(Date meetTime) {
        this.meetTime = meetTime;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getMeetLocation() {
        return meetLocation;
    }

    public void setMeetLocation(String meetLocation) {
        this.meetLocation = meetLocation;
    }

    @Override
    public String toString() {
        return "AbstractTracking{" +
                "trackingID='" + trackingID + '\'' +
                ", trackableID='" + trackableID + '\'' +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", meetTime=" + meetTime +
                ", currentLocation='" + currentLocation + '\'' +
                ", meetLocation='" + meetLocation + '\'' +
                '}';
    }

}
