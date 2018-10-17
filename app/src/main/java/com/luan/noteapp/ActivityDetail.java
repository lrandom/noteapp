package com.luan.noteapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class ActivityDetail extends Activity {
    TextView tvTitle,tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvTitle=(TextView)findViewById(R.id.tvTitle);
        tvContent=(TextView)findViewById(R.id.tvContent);

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        tvTitle.setText(title);
        tvContent.setText(content);
    }
}
