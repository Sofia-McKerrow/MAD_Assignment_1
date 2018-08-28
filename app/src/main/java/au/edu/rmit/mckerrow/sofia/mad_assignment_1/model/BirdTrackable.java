package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;

public class BirdTrackable extends AbstractTrackable implements Trackable {

    public BirdTrackable(int trackableID, String name, String description, String url, String category, String image) {
        super(trackableID, name, description, url, category, image);
    }
}
