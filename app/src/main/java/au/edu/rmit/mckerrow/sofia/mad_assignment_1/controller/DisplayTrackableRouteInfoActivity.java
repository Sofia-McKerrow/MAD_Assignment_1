package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.ReadFile;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackableInfo;

public class DisplayTrackableRouteInfoActivity extends AppCompatActivity {

    private TextView trackableName;
    private ImageView trackableImage;

    private static List<BirdTrackable> trackableList;
    private static Map<String, BirdTrackable> trackableMap;
    private TrackableInfo trackableInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trackable_route_info);

        // Check if a trackableInfo singleton has been created
        if (trackableInfo == null) {
            trackableInfo = TrackableInfo.getSingletonInstance(this);
        }

        trackableList = trackableInfo.getTrackableList();
        trackableMap = trackableInfo.getTrackableMap();
        String trackableID = getIntent().getExtras().getString(TrackableAdapter.TRACKABLE_ID_KEY);
        BirdTrackable birdTrackable = trackableMap.get(trackableID);
        Toast.makeText(this, "Received item " + birdTrackable.getName(), Toast.LENGTH_SHORT).show();

        trackableName = (TextView) findViewById(R.id.trackableName);
        trackableImage = (ImageView) findViewById(R.id.trackableImage);
        trackableName.setText(birdTrackable.getName());

        InputStream inputStream = null;
        try {
            String imageFile = birdTrackable.getImage();
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            trackableImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
