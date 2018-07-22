package com.chatty.android.chattyClient.view.timeLine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.timeLine.TimelineRecyclerViewAdapter;
import com.chatty.android.chattyClient.presenter.timeLine.TimelinePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimelineFragment extends Fragment {
  private TimelinePresenter presenter;

  @BindView(R.id.recyclerView_timeline)
  public RecyclerView recyclerView;
  public RecyclerView.Adapter recyclerViewAdapter;

  public List<String> timeline;

  @Nullable
  @Override
  public View onCreateView(
    @NonNull LayoutInflater inflater,
    @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState
  ) {
    View view = inflater.inflate(R.layout.fragment_timeline, container, false);
    loadDependencies(view);

    initView();
    return view;
  }

  private void loadDependencies(View view) {
    presenter = new TimelinePresenter(this);
    ButterKnife.bind(this, view);
  }

  public void initView() {
    timeline = new ArrayList<>();

    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerViewAdapter = new TimelineRecyclerViewAdapter(getActivity(), timeline);
    recyclerView.setAdapter(recyclerViewAdapter);

    timeline.add("power");
    recyclerViewAdapter.notifyItemChanged(this.timeline.size() - 1);
  }
}
