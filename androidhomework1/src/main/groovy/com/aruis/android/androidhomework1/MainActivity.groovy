package com.aruis.android.androidhomework1

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView

public class MainActivity extends Activity {

    TextView textView;

    List buttonContents = [
            [E.AC, E.PN, E.PER, E.DIVIDE],
            [E.SEVEN, E.EIGHT, E.NINE, E.MULTIPLY],
            [E.FOUR, E.FIVE, E.SIX, E.MINUS],
            [E.ONE, E.TWO, E.THREE, E.PLUS],
            [E.ZERO, E.POINT, E.EQUAL]
    ]

    List buttonList = [];

    Long zeros = 1000000000000000
    Long zeros00 = zeros * 100

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main)

        DisplayMetrics dm = new DisplayMetrics()
        getWindowManager().getDefaultDisplay().getMetrics(dm)

        LayoutParams linearLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, 0, 1)
        LayoutParams layoutParams_zero = new LayoutParams(0, LayoutParams.MATCH_PARENT, 2)
        LayoutParams layoutParams = new LayoutParams(0, LayoutParams.MATCH_PARENT, 1)

        textView = findViewById(R.id.textView)
        text = '0'
        int i = 0

        buttonContents.each {
            LinearLayout _layout = new LinearLayout(this);
            _layout.orientation = LinearLayout.HORIZONTAL

            _layout.layoutParams = linearLayoutParams
            int j = 0
            it.each { e ->
                MyButton btn = new MyButton(this, e);

                btn.layoutParams = e == E.ZERO ? layoutParams_zero : layoutParams
                btn.textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, dm)

                if (j == 3 || (i == 4 && j == 2)) {
                    btn.backgroundResource = R.drawable.button_style_right
                    btn.textColor = Color.WHITE
                } else if (i == 0) {
                    btn.backgroundResource = R.drawable.button_style_top
                } else {
                    btn.backgroundResource = R.drawable.button_style
                }

                btn.setOnClickListener(clickListener)

                buttonList.add(btn)
                _layout.addView(btn)
                j++
            }
            ViewGroup contentParent = (ViewGroup) findViewById(16908290); //可以取得 activity_main.xml指定的布局
            LinearLayout _view = contentParent.getChildAt(0)
            _view.addView(_layout)
            i++
        }
    }

    /**
     * 计算功能未实现
     */
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        void onClick(View view) {
            E data = view.data;
            switch (data) {
                case E.AC:
                    text = '0'
                    break
                case E.PN:
                    if (text.indexOf('-') == 0)
                        text = text.substring(1)
                    else
                        text = '-' + text
                    break
                case E.PER:
                    text = text != '0' ? (text.toFloat() * zeros) / zeros00 : '0'//逻辑尚有bug
                    break
                case E.POINT:
                    if (text.indexOf('.') > -1)
                        break;
                case (E.POINT..E.NINE):
                    if (text == '0' && data.toString() != '.')
                        text = data.toString()
                    else
                        text += data.toString()
                    break
            }

        }
    }

    def setText(String s) {
        textView.text = s
    }

    String getText() {
        return textView.text
    }

}
