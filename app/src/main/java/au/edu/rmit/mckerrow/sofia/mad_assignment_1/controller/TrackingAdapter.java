package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.BirdTracking;

public class TrackingAdapter extends RecyclerView.Adapter<TrackingAdapter.ViewHolder>{
    public static final String TRACKABLE_ID_KEY = "trackable_id_key";
    private Context mContext;
    private List<BirdTracking> trackingList;

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

        String trackableNameValue = "Magpie";
        holder.trackableName.setText(trackableNameValue);
        holder.titleValue.setText(birdTracking.getTitle());
        holder.dateValue.setText(birdTracking.getMeetTime());
        holder.timeValue.setText(birdTracking.getMeetTime());
        holder.locationValue.setText(birdTracking.getMeetLocation());
    }

    @Override
    public int getItemCount() {
        return trackingList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView trackableNameLabel;
        public TextView trackableName;
        public TextView titleLabel;
        public TextView titleValue;
        public TextView dateLabel;
        public TextView dateValue;
        public TextView timeLabel;
        public TextView timeValue;
        public TextView locationLabel;
        public TextView locationValue;

        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            trackableNameLabel = (TextView) itemView.findViewById(R.id.trackableNameLabel);
            trackableName = (TextView) itemView.findViewById(R.id.trackableNameValue);
            titleLabel = (TextView) itemView.findViewById(R.id.titleLabel);
            titleValue = (TextView) itemView.findViewById(R.id.titleValue);
            dateLabel = (TextView) itemView.findViewById(R.id.dateLabel);
            dateValue = (TextView) itemView.findViewById(R.id.dateValue);
            timeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            timeValue = (TextView) itemView.findViewById(R.id.timeValue);
            locationLabel = (TextView) itemView.findViewById(R.id.locationLabel);
            locationValue = (TextView) itemView.findViewById(R.id.locationValue);

            mView = itemView;
        }
    }



}
