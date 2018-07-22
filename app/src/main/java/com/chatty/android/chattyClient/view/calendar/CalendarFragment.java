package com.chatty.android.chattyClient.view.calendar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.calendar.CalendarPresenter;

import butterknife.ButterKnife;

public class CalendarFragment extends Fragment {
  private CalendarPresenter presenter;

  @Nullable
  @Override
  public View onCreateView(
    @NonNull LayoutInflater inflater,
    @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState
  ) {
    View view = inflater.inflate(R.layout.fragment_calendar, container, false);
    loadDependencies(view);
    return view;
  }

  private void loadDependencies(View view) {
    presenter = new CalendarPresenter(this);
    ButterKnife.bind(this, view);
  }
}
