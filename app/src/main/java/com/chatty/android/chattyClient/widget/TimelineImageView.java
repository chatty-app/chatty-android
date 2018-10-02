package com.chatty.android.chattyClient.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class TimelineImageView extends ImageView {
  public static float radius = 18.0f;

  public TimelineImageView(Context context) {
    super(context);
  }

  public TimelineImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public TimelineImageView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    Path clipPath = new Path();
    RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
    clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
    canvas.clipPath(clipPath);
    super.onDraw(canvas);
  }
}
