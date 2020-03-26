package com.yang4an.library;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * author: create by yangfan on 2020-02-21 17:07
 * email: yang4an@gmail.com
 * description:
 * version:
 */
public class LinkMovementMethodOverride implements View.OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        TextView widget = (TextView) v;
        Object text = widget.getText();
        if (text instanceof Spanned) {
            Spanned buffer = (Spanned) text;

            int action = event.getAction();

            if (action == MotionEvent.ACTION_UP
                    || action == MotionEvent.ACTION_DOWN) {
                int x = (int) event.getX();
                int y = (int) event.getY();

                x -= widget.getTotalPaddingLeft();
                y -= widget.getTotalPaddingTop();

                x += widget.getScrollX();
                y += widget.getScrollY();

                Layout layout = widget.getLayout();
                int line = layout.getLineForVertical(y);
                int off = layout.getOffsetForHorizontal(line, x);
                /**
                 * 下面这几行就是解决图片点击错位的
                 */
                float xLeft = layout.getPrimaryHorizontal(off);
                if (xLeft < x) {
                    off += 1;
                } else {
                    off -= 1;
                }

                ClickableSpan[] link = buffer.getSpans(off, off,
                        ClickableSpan.class);

                if (link.length != 0) {
                    if (action == MotionEvent.ACTION_UP) {
                        link[0].onClick(widget);
                    } else if (action == MotionEvent.ACTION_DOWN) {
                        // Selection only works on Spannable text. In our case setSelection doesn't work on spanned text
                        //Selection.setSelection(buffer, buffer.getSpanStart(link[0]), buffer.getSpanEnd(link[0]));
                    }
                    return true;
                }
            }

        }

        return false;
    }

}