package com.chatty.android.chattyClient.presenter.calendar;

import com.chatty.android.chattyClient.module.StateManager.StateManager;
import com.chatty.android.chattyClient.view.calendar.CalendarActivity;

import java.util.HashMap;

public class CalendarPresenter {
  private CalendarActivity view;

  public CalendarPresenter(CalendarActivity view) {
    this.view = view;
  }

  public void construct() {
    StateManager.subscribe(CalendarPresenter::stateListener);
    view.render();
    presenterDidMount();
  }

  private void presenterDidMount() {
    try {
//      TODO: 월 별 일기 쓴 데이터 가져오기
    } catch (Exception e) {

    }
  }

  private static Object stateListener(HashMap state) {
    StateManager.printMap(state);
    return null;
  }
}
