package com.example.jyw.expandablerecyclerview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jyw.expandablerecyclerview.model.Parent;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by JYW on 2017-03-19 019.
 */
@EViewGroup(R.layout.parent_item_organization)
public class ParentView extends FrameLayout {

    Context context;

    @ViewById
    ImageView imageFold, imageAction;

    @ViewById
    TextView textTitle;


    public ParentView(Context context) {
        super(context);
        this.context = context;
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void bind(Parent data) {
        if (data.isExpand()) {
            imageFold.setImageResource(R.drawable.btn_fold_selector);
        } else {
            imageFold.setImageResource(R.drawable.btn_unfold_selector);
        }
        textTitle.setText(data.title);
        imageAction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(context, view);
                popup.inflate(R.menu.view_parent);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.chat:
                            case R.id.note:
                            case R.id.add_group:
                                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });

        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, getResources().getInteger(R.integer.padding), context.getResources().getDisplayMetrics());
        int level = data.getLevel() - 1;
        setPadding(level * padding, 0, 0, 0);
    }
}
