package com.yang4an.library;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;


/**
 * author: create by yangfan on 2020-03-26 15:00
 * email: yang4an@gmail.com
 * description: 可展开折叠的文本控件（用于列表界面,如RecyclerView）
 * version:
 */
public class ExpandableTextView4List extends ExpandableTextView {

    public ExpandableTextView4List(Context context) {
        this(context, null, 0);
    }

    public ExpandableTextView4List(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableTextView4List(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(CharSequence text, boolean open) {
        mCancelAnim = true;
        super.setText(text, open);
        if (mMeasured) {
            toggleText();
        }
    }
}