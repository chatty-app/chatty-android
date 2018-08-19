package com.chatty.android.chattyClient.view.friendsSetting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.friendsSetting.FriendsSettingPresenter;
import com.chatty.android.chattyClient.presenter.main.MainPresenter;
import com.chatty.android.chattyClient.view.setting.SettingActivity;

import butterknife.ButterKnife;

public class FriendsSettingActivity extends AppCompatActivity {
  private static String HEADER_TITLE = "Friends Setting";
  private FriendsSettingPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    construct();
  }

  private void construct() {
    setContentView(R.layout.activity_friends_setting);
    ButterKnife.bind(this);
    presenter = new FriendsSettingPresenter(this);
    presenter.construct();
  }

  public void render() {
    headerRender();
  }

  private void headerRender() {
    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(HEADER_TITLE);
  }
}
