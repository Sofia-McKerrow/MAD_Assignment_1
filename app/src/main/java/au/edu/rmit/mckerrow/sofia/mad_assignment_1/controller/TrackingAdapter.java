package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        holder.setData(birdTracking, position);

        // holder.trackableName.setText("Magpie");
        // holder.titleValue.setText(birdTracking.getTitle());
//        holder.dateValue.setText(birdTracking.getMeetTime());
//        holder.timeValue.setText(birdTracking.getMeetTime());
//        holder.locationValue.setText(birdTracking.getMeetLocation());

        // holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return trackingList.size();
    }

    // Add tracking item to recyclerview
    public void addItem(int position, BirdTracking currentTracking) {
        trackingList.add(position, currentTracking);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, trackingList.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

        private BirdTracking currentTracking;
        private int position;

        private Button addTracking;
        public View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            addTracking = (Button) itemView.findViewById(R.id.addTracking);

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

        public void setData(BirdTracking currentTracking, int position) {
            this.trackableName.setText("Magpie");
            this.titleValue.setText(currentTracking.getTitle());
            this.dateValue.setText(currentTracking.getMeetTime());
            this.timeValue.setText(currentTracking.getMeetTime());
            this.locationValue.setText(currentTracking.getMeetLocation());
            this.position = position;
            this.currentTracking = currentTracking;
        }

        public void setListeners() {
            // addTracking.setOnClickListener(ViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.addTracking:
                    addItem(position, currentTracking);
            }
        }
    }

}
