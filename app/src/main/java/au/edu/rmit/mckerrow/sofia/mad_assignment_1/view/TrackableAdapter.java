package au.edu.rmit.mckerrow.sofia.mad_assignment_1.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import au.edu.rmit.mckerrow.sofia.mad_assignment_1.R;
import au.edu.rmit.mckerrow.sofia.mad_assignment_1.model.PlaneTrackable;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TrackableAdapter extends RecyclerView.Adapter<TrackableAdapter.ViewHolder> {
    private Context mContext;
    private List<PlaneTrackable> trackableList;

    public TrackableAdapter(Context context, List<PlaneTrackable> trackables) {
        this.mContext = context;
        this.trackableList = trackables;
        // trackables.addAll(trackableMap.values());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_trackable, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrackableAdapter.ViewHolder holder, int position) {
        PlaneTrackable planeTrackable = trackableList.get(position);

        holder.tvName.setText(planeTrackable.getName());
//        try {
//            holder.tvName.setText(planeTrackable.getName());
////            String imageFile = planeTrackable.getImage();
////            InputStream inputStream = mContext.getAssets().open(imageFile);
////            Drawable d = Drawable.createFromStream(inputStream, null);
////            holder.imageView.setImageDrawable(d);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int getItemCount() {
        return trackableList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.trackableNameText);
        }
    }
}
