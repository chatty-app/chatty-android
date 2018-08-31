package com.chatty.android.chattyClient.presenter.diaryDetail;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.chatty.android.chattyClient.model.Diary;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.model.TimelineEntry;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.state.action.DiaryAction;
import com.chatty.android.chattyClient.view.diaryDetail.DiaryDetailActivity;

import java.util.ArrayList;

public class DiaryDetailPresenter {
  private DiaryDetailActivity view;

  public DiaryDetailPresenter(DiaryDetailActivity view) {
    this.view = view;
  }

  public void construct() {
    StateManagerWrapper.subscribe(this::stateListener);
    ArrayList<Diary> diaries = StateManagerWrapper.getState().getDiary();

    this.view.initRender(
      diaries
    );
    presenterDidMount();
  }

  private void presenterDidMount() {
    try {
      StateManagerWrapper.dispatch(DiaryAction.requestGetDiaryDetail());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object stateListener(State state) {
    StateManagerWrapper.log(this.getClass().getSimpleName(), state);

    ArrayList<Diary> diary = state.getDiary();
    Log.e("ERRORORRO", String.valueOf(diary));
    this.view.render(
      diary
    );
    return null;
  }
}
