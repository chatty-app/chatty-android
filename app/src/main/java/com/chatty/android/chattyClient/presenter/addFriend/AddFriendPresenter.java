package com.chatty.android.chattyClient.presenter.addFriend;

import android.content.SharedPreferences;

import com.chatty.android.chattyClient.App;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedPresenter;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.view.addFriend.AddFriendActivity;

public class AddFriendPresenter implements ExtendedPresenter<State> {
  AddFriendActivity view;

  public AddFriendPresenter(AddFriendActivity addFriendActivity) {
    view = addFriendActivity;
  }

  public void construct() {
    StateManagerWrapper.subscribe(this::stateListener);
    view.render();
    this.presenterDidMount();
  }

  @Override
  public void presenterDidMount() {
  }

  public Object stateListener(State state) {
    return null;
  }

  public void setIsFriend() {
    SharedPreferences.Editor editor = App.userPreference.edit();
    editor.putBoolean(App.IS_FRIEND, true);
    editor.commit();
  }
}
