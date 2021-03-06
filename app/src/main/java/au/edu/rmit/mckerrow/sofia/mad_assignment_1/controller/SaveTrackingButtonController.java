package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTracking;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.ReadFile;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackingInfo;

public class SaveTrackingButtonController implements View.OnClickListener{

    private Context mContext;
    private static List<BirdTracking> trackingList;
    private TrackingInfo trackingInfo;
    private BirdTracking tracking;
    private TrackingAdapter adapter;
    private AddEditTrackingActivity activity;
    private List<BirdTrackable> trackableList;

    public SaveTrackingButtonController(Context mContext, AddEditTrackingActivity activity) {
        this.mContext = mContext;
        this.activity = activity;
    }

    // Add tracking to the trackings list when the Save button is clicked
    @Override
    public void onClick(View v) {
        addTracking(activity);

        adapter = DisplayTrackingsListActivity.getAdapter();
        adapter.notifyDataSetChanged();

        mContext.startActivity(new Intent(mContext, TabWidgetActivity.class));
    }

    public void addTracking(AddEditTrackingActivity activity) {
        trackingInfo = TrackingInfo.getSingletonInstance(mContext);
        trackingList = trackingInfo.getTrackingList();

        if (trackingList == null) {
            trackingList = new ArrayList<BirdTracking>();
        }

        String trackingID = "trng" + trackingList.size() + 1;

        String trackableID = null;
        Spinner trackableSpinner = (Spinner) activity.findViewById(R.id.trackableNameSpinner);
        String trackableName = trackableSpinner.getSelectedItem().toString();

        if (trackableList != null) {
            trackableList.clear();
        }
        ReadFile.readTrackableFile(mContext);
        trackableList = ReadFile.getTrackableList();

        // Get trackable ID from the selected trackable name
        for (int i = 0; i < trackableList.size(); i++) {
            if (trackableName.equals(trackableList.get(i).getName())) {
                trackableID = Integer.toString(trackableList.get(i).getTrackableID());
                break;
            }
        }

        EditText titleValue = (EditText) activity.findViewById(R.id.titleEntry);
        String title = titleValue.getText().toString();
        String startTime = "05/07/2018 1:05:00 PM";
        String finishTime = "05/07/2018 1:10:00 PM";
        Spinner meetDateSpinner = (Spinner) activity.findViewById(R.id.meetDateSpinner);
        String meetTime = meetDateSpinner.getSelectedItem().toString();
        String currentLocation = "-37.820666, 144.958277";
        String meetLocation = "-37.820666, 144.958277";

        tracking = new BirdTracking(trackingID, trackableID, title, startTime, finishTime, meetTime, currentLocation, meetLocation);

        trackingList.add(tracking);
        trackingInfo.setTrackingList(trackingList);
    }

    public void editTracking(AddEditTrackingActivity activity) {
        String trackingID = activity.getIntent().getExtras().getString(TrackingAdapter.TRACKING_ID_KEY);
    }
}
