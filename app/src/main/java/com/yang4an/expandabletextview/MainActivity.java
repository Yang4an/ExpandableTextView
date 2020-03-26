package com.yang4an.expandabletextview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yang4an.library.ExpandableTextView4List;

public class MainActivity extends AppCompatActivity {

    private ExpandableTextView4List tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        String[] array = getResources().getStringArray(R.array.data);

        tv.setText(array[0]);

    }
}
