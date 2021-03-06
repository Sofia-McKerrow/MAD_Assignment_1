package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;

public class TabWidgetActivity extends android.app.TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        TabHost.TabSpec spec;
        Intent intent;

        // Create a new TabSpec using tab host
        spec = tabHost.newTabSpec("trackables");
        // Set "Bird Trackables" as the indicator
        spec.setIndicator("Trackables");
        // Create an intent to launch an activity for the tab
        intent = new Intent(this, DisplayTrackablesListActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        // Create a new TabSpec using tab host
        spec = tabHost.newTabSpec("trackings");
        // Set "Bird Trackables" as the indicator
        spec.setIndicator("Trackings");
        // Create an intent to launch an activity for the tab
        intent = new Intent(this, DisplayTrackingsListActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        // Set trackables tab to open when app first opens
        tabHost.setCurrentTab(0);
    }
}
