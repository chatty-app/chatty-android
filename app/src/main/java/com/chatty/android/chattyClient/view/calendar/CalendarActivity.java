package com.chatty.android.chattyClient.view.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.calendar.CalendarPresenter;

import butterknife.ButterKnife;

public class CalendarActivity extends AppCompatActivity {
  private CalendarPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    construct();
  }

  private void construct() {
    setContentView(R.layout.activity_calendar);
    ButterKnife.bind(this);
    presenter = new CalendarPresenter(this);
    presenter.construct();
  }

  public void render() {
  }
}
