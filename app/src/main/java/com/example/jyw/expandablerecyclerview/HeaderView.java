package com.example.jyw.expandablerecyclerview;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by JYW on 2017-03-20 020.
 */
@EViewGroup(R.layout.header_item_organization)
public class HeaderView extends FrameLayout {

    @ViewById
    EditText editText;

    public HeaderView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void bind(String text) {
        editText.setHint(text);
    }
}
