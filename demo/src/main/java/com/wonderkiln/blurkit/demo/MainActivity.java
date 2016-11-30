package com.wonderkiln.blurkit.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //private BlurLayout blurLayout;
    private Button showFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //blurLayout = (BlurLayout) findViewById(R.id.blurLayout);
        showFragmentButton = (Button)findViewById(R.id.showFragmentButton);
        showFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.pull_in_top, R.anim.push_out_bottom, R.anim.pull_in_bottom, R.anim.push_out_top)
                    .add(android.R.id.content, new TestFragment())
                    .addToBackStack(null)
                    .commit();
            }
/*
        blurLayout.animate().translationY(movement).setDuration(1500).setListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                movement = movement > 0 ? -150 : 150;
                blurLayout.animate().translationY(movement).setDuration(1500).setListener(this).start();
            }
        }).start();
*/

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //blurLayout.startBlur();
        //blurLayout.lockView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //blurLayout.pauseBlur();
    }
}
