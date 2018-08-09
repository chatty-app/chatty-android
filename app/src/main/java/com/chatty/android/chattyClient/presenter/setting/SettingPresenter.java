package com.chatty.android.chattyClient.presenter.setting;

import com.chatty.android.chattyClient.module.StateManager.StateManager;
import com.chatty.android.chattyClient.view.setting.SettingActivity;

import java.util.HashMap;

public class SettingPresenter {
  private SettingActivity view;

  public SettingPresenter(SettingActivity view) {
    this.view = view;
  }

  public void construct() {
    StateManager.subscribe(SettingPresenter::stateListener);
    view.render();
  }

  private static Object stateListener(HashMap state) {
    StateManager.printMap(state);
    return null;
  }
}
