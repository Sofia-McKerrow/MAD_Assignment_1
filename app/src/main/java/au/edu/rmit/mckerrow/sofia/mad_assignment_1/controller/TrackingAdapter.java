package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTrackable;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTracking;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.TrackableInfo;

public class TrackingAdapter extends RecyclerView.Adapter<TrackingAdapter.ViewHolder>{
    public static final String TRACKABLE_ID_KEY = "trackable_id_key";
    private Context mContext;
    private List<BirdTracking> trackingList;
    private List<BirdTrackable> trackableList;
    private TrackableInfo trackableInfo;
    public static final String TRACKING_ID_KEY = "tracking_id_key";

    public TrackingAdapter(Context mContext, List<BirdTracking> trackingList) {
        this.mContext = mContext;
        this.trackingList = trackingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.tracking_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrackingAdapter.ViewHolder holder, int position) {
        final BirdTracking birdTracking = trackingList.get(position);
        holder.setData(birdTracking, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return trackingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView trackableNameLabel;
        private TextView trackableName;
        private TextView titleLabel;
        private TextView titleValue;
        private TextView dateLabel;
        private TextView dateValue;
        private TextView locationLabel;
        private TextView locationValue;
        private Button editButton;
        private Button removeButton;

        private BirdTracking currentTracking;
        private int position;

        public View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            trackableNameLabel = (TextView) itemView.findViewById(R.id.trackableNameLabel);
            trackableName = (TextView) itemView.findViewById(R.id.trackableNameValue);
            titleLabel = (TextView) itemView.findViewById(R.id.titleLabel);
            titleValue = (TextView) itemView.findViewById(R.id.titleValue);
            dateLabel = (TextView) itemView.findViewById(R.id.dateLabel);
            dateValue = (TextView) itemView.findViewById(R.id.dateValue);
            locationLabel = (TextView) itemView.findViewById(R.id.locationLabel);
            locationValue = (TextView) itemView.findViewById(R.id.locationValue);
            editButton = (Button) itemView.findViewById(R.id.editTracking);
            removeButton = (Button) itemView.findViewById(R.id.removeTracking);

            mView = itemView;
        }

        public void setData(BirdTracking currentTracking, int position) {
            String trackableID = currentTracking.getTrackableID();
            String trackableName = null;
            trackableInfo = TrackableInfo.getSingletonInstance(mContext);
            trackableList = trackableInfo.getTrackableList();

            // Get trackable name for selected trackable from the trackableID of the currentTracking object
            for (int i = 0; i < trackableList.size(); i++) {
                if (trackableList.get(i).getTrackableID() == Integer.parseInt(trackableID)) {
                    trackableName = trackableList.get(i).getName();
                    break;
                }
            }

            this.trackableName.setText(trackableName);
            this.titleValue.setText(currentTracking.getTitle());
            this.dateValue.setText(currentTracking.getMeetTime());
            this.locationValue.setText(currentTracking.getMeetLocation());
            this.position = position;
            this.currentTracking = currentTracking;
        }

        public void setListeners() {
            editButton.setOnClickListener(ViewHolder.this);
            removeButton.setOnClickListener(ViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                // If edit button is clicked
                case R.id.editTracking:
                    editTracking(position);
                    break;

                // If remove button is clicked
                case R.id.removeTracking:
                    removeTracking(position);
                    break;
            }
        }
    }

    // Edit selected tracking
    public void editTracking(int position) {

    }

    // Remove tracking from trackingList
    public void removeTracking(int position) {
        trackingList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, trackingList.size());
    }

}
