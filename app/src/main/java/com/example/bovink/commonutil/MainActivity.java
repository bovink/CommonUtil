package com.example.bovink.commonutil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.bovink.commonutil.util.MethodCache;
import com.example.bovink.commonutil.view.GradientRelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GradientRelativeLayout gradientLinearLayout = (GradientRelativeLayout) findViewById(R.id.gll_myorder);
        gradientLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");
                MethodCache.screenshot(MainActivity.this);
            }
        });
    }
}
