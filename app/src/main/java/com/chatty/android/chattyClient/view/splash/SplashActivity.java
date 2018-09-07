package com.chatty.android.chattyClient.view.splash;

import android.animation.Animator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.view.main.MainActivity;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashActivity extends AppCompatActivity {

  private Handler handler = new Handler();
  private static final int ACTIVITY_START_DELAY_MILLIS = 1000 * 3;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    init();
  }

  private void init() {
    YoYo.with(Techniques.FadeOut)
      .delay(200)
      .duration(1300)
      .withListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {

        }

        @Override
        public void onAnimationEnd(Animator animator) {
          updateLogo();
        }

        @Override
        public void onAnimationCancel(Animator animator) {

        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }
      })
      .playOn(findViewById(R.id.imageView_logo_symbol));

    startMainActivityWithDelay();
  }

  private void updateLogo() {
    ImageView logoLetter = findViewById(R.id.imageView_logo_letter);
    logoLetter.setVisibility(View.VISIBLE);
    YoYo.with(Techniques.FadeIn)
      .duration(1300)
      .playOn(logoLetter);
  }

  private void startMainActivityWithDelay() {
    Runnable startActivityRunnable = new Runnable() {
      @Override
      public void run() {
        startMainActivity();
      }
    };

    handler.postDelayed(
      startActivityRunnable,
      ACTIVITY_START_DELAY_MILLIS
    );
  }

  private void startMainActivity() {
    startActivity(new Intent(this, MainActivity.class));
    finish();
  }
}
