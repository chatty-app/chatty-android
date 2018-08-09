package com.chatty.android.chattyClient.view.main;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.main.MainPresenter;
import com.chatty.android.chattyClient.presenter.main.TimelineRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  private MainPresenter presenter;

  @BindView(R.id.floatingActionButton_write)
  public FloatingActionButton writeButton;

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
