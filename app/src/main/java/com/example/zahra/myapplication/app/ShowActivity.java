package com.example.zahra.myapplication.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.zahra.myapplication.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class ShowActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewTitle;
    TextView textViewGroup;
    LinkedList<Integer> list = new LinkedList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        imageView=(ImageView)findViewById(R.id.imageActivityShow);
        textViewTitle=(TextView)findViewById(R.id.titleActivityShow);
        textViewGroup=(TextView)findViewById(R.id.gruopActivityShow);
        Intent intent = getIntent();
        final int[] image = {intent.getIntExtra("image", R.drawable.image_1_1_1)};
        final ArrayList<Integer> imageList = intent.getIntegerArrayListExtra("imageList");

        for (int i = 0; i <imageList.size(); i++) {
            list.addLast(imageList.get(i));
        }
        String title=intent.getStringExtra("title");
        String group=intent.getStringExtra("group");
        imageView.setImageResource(image[0]);
        textViewTitle.setText(title);
        textViewGroup.setText(group);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 imageList.add(image[0]);
                 imageView.setImageResource(imageList.get(0));
                 image[0] =imageList.get(0);
                 imageList.remove(0);

            }
        });
    }
}
