package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.ReadFile;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackableInfo;

public class FilterController implements AdapterView.OnItemSelectedListener {

    private Context mContext;
    private List<BirdTrackable> trackableList;
    private static List<BirdTrackable> filteredList;
    private List<BirdTrackable> tempList;
    private String category;
    private TrackableAdapter adapter;
    private TrackableInfo trackableInfo;

    private static final String LOG_TAG = "MyTag";

    public FilterController(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        adapter = DisplayTrackablesActivity.getAdapter();

        filteredList = new ArrayList<>();

        if (trackableList != null) {
            trackableList.clear();
        }
        ReadFile.readTrackableFile(mContext);
        trackableList = ReadFile.getTrackableList();

        // Sort list alphabetically
        Collections.sort(trackableList, new Comparator<BirdTrackable>() {
            @Override
            public int compare(BirdTrackable o1, BirdTrackable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

//        for (int i = 0; i < trackableList.size(); i++) {
//            Log.i(LOG_TAG, "trackableList " + trackableList.get(i).toString());
//        }

        if (filteredList != null) {
            filteredList.clear();
        }

        switch (position) {
            // If All is selected
            case 0:
               filteredList.addAll(trackableList);
               adapter.notifyDataSetChanged();

               break;
            case 1:
                // If Bird of Prey category is selected
                category = "Bird of Prey";
                filteredList = filterTrackableList(trackableList, category);
                adapter.notifyDataSetChanged();

                for (int i = 0; i < trackableList.size(); i++) {
                    Log.i(LOG_TAG, "trackableList " + trackableList.get(i).toString());
                }

                for (int i = 0; i < filteredList.size(); i++) {
                    Log.i(LOG_TAG, "filteredList " + filteredList.get(i).toString());
                }

                break;
            case 2:
                // If Bush Bird category is selected
                category = "Bush Bird";
                filteredList = filterTrackableList(trackableList, category);
                adapter.notifyDataSetChanged();

                for (int i = 0; i < trackableList.size(); i++) {
                    Log.i(LOG_TAG, "trackableList " + trackableList.get(i).toString());
                }

                for (int i = 0; i < filteredList.size(); i++) {
                    Log.i(LOG_TAG, "filteredList " + filteredList.get(i).toString());
                }

                break;
            case 3:
                // If Parrot category is selected
                category = "Parrot";
                filteredList = filterTrackableList(trackableList, category);
                adapter.notifyDataSetChanged();
                break;
            case 4:
                // If Sea Bird category is selected
                category = "Sea Bird";
                filteredList = filterTrackableList(trackableList, category);
                adapter.notifyDataSetChanged();
                break;
            case 5:
                // If Water Bird category is selected
                category = "Water Bird";
                filteredList = filterTrackableList(trackableList, category);
                adapter.notifyDataSetChanged();
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

    public static List<BirdTrackable> getFilteredList() {
        return filteredList;
    }
}
