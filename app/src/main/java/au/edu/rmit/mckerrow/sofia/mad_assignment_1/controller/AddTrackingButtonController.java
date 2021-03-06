package au.edu.rmit.mckerrow.sofia.mad_assignment_1.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class AddTrackingButtonController implements View.OnClickListener{
    Context mContext;

    public AddTrackingButtonController(Context mContext) {
        this.mContext = mContext;
    }

    // Go to AddEditTracking activity when Add Tracking button is clicked
    @Override
    public void onClick(View v) {
        mContext.startActivity(new Intent(mContext, AddEditTrackingActivity.class));
    }
}
