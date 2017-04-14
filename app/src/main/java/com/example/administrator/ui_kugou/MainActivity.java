package com.example.administrator.ui_kugou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.ui_kugou.numberKeyboard.MyView;

public class MainActivity extends AppCompatActivity implements MyView.OnNumberClickListener{

    private MyView mNkvKeyboard;
    private TextView mTvText;
    private String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mTvText = (TextView) findViewById(R.id.am_tv_text);
        mNkvKeyboard = (MyView) findViewById(R.id.am_nkv_keyboard);
        mNkvKeyboard.setOnNumberClickListener(this);
    }

    @Override
    public void onNumberReturn(String number) {
        str += number;
        setTextContent(str);
    }

    @Override
    public void onNumberDelete() {
        if (str.length() <= 1) {
            str = "";
        } else {
            str = str.substring(0, str.length() - 1);
        }
        setTextContent(str);
    }

    private void setTextContent(String content) {
        mTvText.setText(content);
    }
}
