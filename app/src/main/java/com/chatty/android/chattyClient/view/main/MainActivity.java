package com.chatty.android.chattyClient.view.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.main.MainPresenter;
import com.chatty.android.chattyClient.presenter.main.TimelineRecyclerViewAdapter;
import com.chatty.android.chattyClient.view.calendar.CalendarActivity;
import com.chatty.android.chattyClient.view.setting.SettingActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  public static final String HEADER_TITLE = "HEADER_TITLE";
  public static final String CALENDAR = "Calendar";
  public static final String SETTING = "Setting";
  private MainPresenter presenter;

  @BindView(R.id.btn_start_chatting)
  public FloatingActionButton writeButton;

  @BindView(R.id.btn_main_header_setting)
  public ImageButton settingButton;

  @BindView(R.id.btn_main_header_calendar)
  public ImageButton calenderButton;

  @BindView(R.id.recyclerView_timeline)
  public RecyclerView recyclerView;
  private RecyclerView.Adapter recyclerViewAdapter;

  private List<String> timeline;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    construct();
  }

  private void construct() {
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    presenter = new MainPresenter(this);
    presenter.construct();
  }

  public void render(View.OnClickListener handleClickWriteButton) {
    renderWriteButton(handleClickWriteButton);
    renderTimeLineView();
    renderMainHeader();
  }

  private void renderMainHeader() {
    calenderButton.setOnClickListener(view -> {
        Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
        String message = CALENDAR;
        intent.putExtra(HEADER_TITLE, message);
        startActivity(intent);
    });
    settingButton.setOnClickListener(view -> {
      Intent intent = new Intent(this, SettingActivity.class);
      String message = SETTING;
      intent.putExtra(HEADER_TITLE, message);
      startActivity(intent);
    });
  }

  private void renderTimeLineView() {
    timeline = new ArrayList<>();
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerViewAdapter = new TimelineRecyclerViewAdapter(this, timeline);
    recyclerView.setAdapter(recyclerViewAdapter);

    timeline.add("power");
    recyclerViewAdapter.notifyItemChanged(this.timeline.size() - 1);
  }

  private void renderWriteButton(View.OnClickListener handleClickWriteButton) {
    writeButton.setOnClickListener(handleClickWriteButton);
  }
}
