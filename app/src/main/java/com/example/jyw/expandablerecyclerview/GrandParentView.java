package com.example.jyw.expandablerecyclerview;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jyw.expandablerecyclerview.model.GrandParent;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by JYW on 2017-03-19 019.
 */
@EViewGroup(R.layout.grand_item_organization)
public class GrandParentView extends FrameLayout {

    Context context;

    @ViewById
    ImageView imageFold;

    @ViewById
    TextView textTitle;

    public GrandParentView(Context context) {
        super(context);
        this.context = context;
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void bind(GrandParent data) {
        if (data.isExpand()) {
            imageFold.setImageResource(R.drawable.btn_fold_selector);
        } else {
            imageFold.setImageResource(R.drawable.btn_unfold_selector);
        }
        textTitle.setText(data.title);
    }
}
