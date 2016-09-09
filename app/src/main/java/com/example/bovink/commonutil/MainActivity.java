package com.example.bovink.commonutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.bovink.commonutil.view.GradientLinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GradientLinearLayout gradientLinearLayout = (GradientLinearLayout) findViewById(R.id.gll_myorder);
        gradientLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");
            }
        });
    }
}
