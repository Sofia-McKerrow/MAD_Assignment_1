package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackableInfo;

public class FilterController implements AdapterView.OnItemSelectedListener {

    private Context mContext;
    private List<BirdTrackable> trackableList;
    private List<BirdTrackable> filteredList;
    private TrackableInfo trackableInfo;
    private String category;

    public FilterController(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        trackableInfo = TrackableInfo.getSingletonInstance(mContext);
        trackableList = trackableInfo.getTrackableList();
        if (filteredList != null) {
            filteredList.clear();
        }

        switch (position) {
            // If All is selected
            case 0:
               filteredList = trackableList;
               DisplayTrackablesActivity.getAdapter().notifyDataSetChanged();
               break;
            case 1:
                category = "Bird of Prey";
                filteredList = filterTrackableList(trackableList, category);
                DisplayTrackablesActivity.getAdapter().notifyDataSetChanged();
               break;
            case 2:
                category = "Bush Bird";
                filteredList = filterTrackableList(trackableList, category);
                DisplayTrackablesActivity.getAdapter().notifyDataSetChanged();
                break;
            case 3:
                category = "Parrot";
                filteredList = filterTrackableList(trackableList, category);
                DisplayTrackablesActivity.getAdapter().notifyDataSetChanged();
                break;
            case 4:
                category = "Sea Bird";
                filteredList = filterTrackableList(trackableList, category);
                DisplayTrackablesActivity.getAdapter().notifyDataSetChanged();
                break;
            case 5:
                category = "Water Bird";
                filteredList = filterTrackableList(trackableList, category);
                DisplayTrackablesActivity.getAdapter().notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // Filter trackable list by category
    public List<BirdTrackable> filterTrackableList(List<BirdTrackable> list, String category) {
        List<BirdTrackable> toRemove = new ArrayList<BirdTrackable>();

        // Remove trackables in the list which don't match the category selected
        for (BirdTrackable trackable : list) {
            if (!trackable.getCategory().equals(category)) {
                toRemove.add(trackable);
            }
        }

        list.removeAll(toRemove);

        return list;
    }
}
