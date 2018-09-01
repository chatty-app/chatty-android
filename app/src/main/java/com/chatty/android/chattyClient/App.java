package com.chatty.android.chattyClient;

import android.app.Application;
import android.content.SharedPreferences;

import com.chatty.android.chattyClient.api.ChattyApi;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.state.reducers.Reducers;

public class App extends Application {
  public static final String USER_DATA = "USER_DATA";
  public static final String IS_FRIEND = "IS_FRIEND";
  public static SharedPreferences userPreference;
  public static boolean isFriend;

  @Override
  public void onCreate() {
    super.onCreate();
    construct();
  }

  private void construct() {
    ChattyApi.initialize();
    this.initializeStateManager();
    this.checkFriend();
  }

  private void checkFriend() {
    userPreference = getSharedPreferences(this.USER_DATA, MODE_PRIVATE);
    isFriend = userPreference.getBoolean(this.IS_FRIEND, false);
  }

  private void initializeStateManager() {
    StateManagerWrapper.initialize(Reducers::reduce);
  }
}
