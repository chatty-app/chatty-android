package com.chatty.android.chattyClient.presenter.friendsSetting;

import com.chatty.android.chattyClient.module.StateManager.StateManager;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivity;

import java.util.HashMap;

public class FriendsSettingPresenter {
  private FriendsSettingActivity view;

  public FriendsSettingPresenter(FriendsSettingActivity view) {
    this.view = view;
  }

  public void construct() {
    StateManager.subscribe(FriendsSettingPresenter::stateListener);
    view.render();
    presenterDidMount();
  }

  private void presenterDidMount() {
  }

  public static Object stateListener(HashMap state) {
    StateManager.printMap(state);
    return null;
  }
}
