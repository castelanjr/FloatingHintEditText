package com.castelanjr.floatinghintedittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created with IntelliJ IDEA.
 * User: castelanjr
 * Date: 12/7/13
 * Time: 7:24 PM
 * Copyright (C) 2013 Nyvra Software. All rights reserved.
 */
public class FloatHintEditText extends EditText {
    private Paint mTextPaint;

    public FloatHintEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFloatingHint();
    }

    private void initFloatingHint() {
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(10 * getResources().getDisplayMetrics().density);
        mTextPaint.setColor(Color.TRANSPARENT);

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() == 0) {
                    mTextPaint.setColor(getHintTextColors().getDefaultColor());
                    invalidate();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    mTextPaint.setColor(Color.TRANSPARENT);
                    invalidate();
                }
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(getHint().toString(), getPaddingLeft(), getPaddingTop(), mTextPaint);
    }
}
