package com.example.ahosseini.test;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;


public class HorizontalProgressBar extends View {
   static final int GERAVITY_TOP = 0;
   static final int GERAVITY_Down = 1;
   Paint paint;
   private int lastProgress;
   private int progress;
   private int value;
   private int strok = 5;
   private int color;
   private int screenWidth;
   private int gravity;
   private Interpolator interpolator;
   public HorizontalProgressBar(Context context) {
      super(context);
   }

   public HorizontalProgressBar(Context context, @Nullable AttributeSet attrs) {
      super(context, attrs);
      paint = new Paint();
      paint.setColor(Color.RED);
      paint.setStrokeWidth(strok);
   }

   public HorizontalProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);

   }


   @Override
   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
      Log.d("measure get size", "" + MeasureSpec.getSize(widthMeasureSpec) + " " + MeasureSpec.getSize(heightMeasureSpec));
      screenWidth = MeasureSpec.getSize(widthMeasureSpec);
      setMeasuredDimension(screenWidth, heightMeasureSpec);
      Log.d("x:", progress + "");

   }

   @Override
   protected void onDraw(Canvas canvas) {
      super.onDraw(canvas);
      canvas.drawLine(0, 0, value, 0, paint);
   }

   public void setProgress(int progressPercentage) {
      this.progress = progressPercentage * screenWidth / 100;
      value = progress;
      progressAnimator();
   }

   public int getProgress() {
      return this.progress;
   }

   public void setStrok(int strok) {
      this.strok = strok;
   }

   public int getStrok() {
      return strok;
   }

   public void setColor(int a, int r, int g, int b) {
      this.color = Color.argb(a, r, g, b);
   }

   public int getColor() {
      return color;
   }

   private void progressAnimator() {

      PropertyValuesHolder progressHolder = PropertyValuesHolder.ofInt("value", lastProgress, progress);
      lastProgress = progress;
      Log.d("animation", "" + String.valueOf(progress));
      ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(this, progressHolder);
      animator.setDuration(5000).setInterpolator(new AccelerateDecelerateInterpolator());
      animator.start();
   }


   public void setGravity(int gravity) {
      if (gravity == 0 || gravity == 1) {
         this.gravity = gravity;
         return;
      }
      this.gravity = 0;
   }

   public int getGravity() {
      return gravity;
   }

   private void setValue(int value) {
      this.value = value;
      invalidate();
   }

   public void setInterpolator(Interpolator interpolator) {
      this.interpolator = interpolator;
   }

}


