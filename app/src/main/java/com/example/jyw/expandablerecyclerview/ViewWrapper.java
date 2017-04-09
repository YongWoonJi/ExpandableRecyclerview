package com.example.jyw.expandablerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by JYW on 2017-03-18 018.
 */

public class ViewWrapper extends RecyclerView.ViewHolder {

    private View view;

    public ViewWrapper(View itemView) {
        super(itemView);
        view = itemView;
    }

    public View getView() {
        return view;
    }
}
