package com.example.jyw.expandablerecyclerview;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.jyw.expandablerecyclerview.model.Child;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by JYW on 2017-03-19 019.
 */
@EViewGroup(R.layout.child_item_organization)
public class ChildView extends FrameLayout {

    Context context;

    @ViewById
    ImageView imageProfile, imageChat;

    @ViewById
    TextView textName, textPosition, textGroup;

    public ChildView(Context context) {
        super(context);
        this.context = context;
    }

    public void bind(Child data) {
        Glide.with(context).load(data.getImgUrl())
                .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, 200, 0))
                .into(imageProfile);

        textName.setText(data.getName());
        textPosition.setText(data.getPosition());
        textGroup.setText(data.getGroup());
        imageChat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "채팅아이콘 터치", Toast.LENGTH_SHORT).show();
            }
        });

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, getResources().getInteger(R.integer.padding), getResources().getDisplayMetrics());
        int level = data.getLevel() - 2;
        setPadding(level * padding, 0, 0, 0);
    }
}
