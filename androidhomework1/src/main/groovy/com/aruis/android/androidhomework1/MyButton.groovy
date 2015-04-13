package com.aruis.android.androidhomework1

import android.content.Context
import android.widget.Button

/**
 * Created by liurui on 15/4/11.
 */
class MyButton extends Button {

    def data

    private void setData(value) {
        this.data = value
        text = value.toString()
    }

    MyButton(Context context, value) {
        super(context)
        setData(value)
    }
}
