package com.chatty.android.chattyClient;

import android.app.Application;

import com.chatty.android.chattyClient.api.ChattyApi;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    construct();
  }

  private void construct() {
    ChattyApi.initialize();
  }

}
