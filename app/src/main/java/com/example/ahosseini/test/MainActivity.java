package com.example.ahosseini.test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   TextView txt;
   FloatingActionButton fab;
   int num = 1;
   BottomAppBar bottomAppBar;
   int a = 0, b = 1;
   HorizontalProgressBar progressBar;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      txt = findViewById(R.id.txt);
      fab = findViewById(R.id.fab);
      bottomAppBar = findViewById(R.id.app_bar);
      fab.setOnClickListener(this);
      txt.setText(String.valueOf(num));
      progressBar = findViewById(R.id.progress);
      PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofFloat("alpha", 1, 0);
      PropertyValuesHolder witdhHolder = PropertyValuesHolder.ofFloat("scaleX", 0, 8);
      PropertyValuesHolder heightHolder = PropertyValuesHolder.ofFloat("scaleY", 0, 8);
      ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(txt, alphaHolder, witdhHolder, heightHolder);
      animator.setInterpolator(new AccelerateDecelerateInterpolator());
      animator.setDuration(4000).addListener(new AnimatorListenerAdapter() {
         @Override
         public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            num += 5;
            txt.setText(String.valueOf(num));
            animation.start();
         }
      });
      animator.start();
   }

   @Override
   public void onClick(View v) {
      progressBar.setProgress(num);

   }
}
