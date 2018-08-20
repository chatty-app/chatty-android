package com.chatty.android.chattyClient.presenter.friendsSetting;

import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivity;

import java.util.HashMap;

public class FriendsSettingPresenter {
  private FriendsSettingActivity view;

  public FriendsSettingPresenter(FriendsSettingActivity view) {
    this.view = view;
  }

  public void construct() {
    StateManagerWrapper.subscribe(this::stateListener);
    view.render();
    presenterDidMount();
  }

  private void presenterDidMount() {
  }

  public Object stateListener(State state) {
    StateManagerWrapper.log(this.getClass().getSimpleName(), state);
    return null;
  }
}
