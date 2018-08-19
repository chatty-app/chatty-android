package com.chatty.android.chattyClient.view.friendsSetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.friendsSetting.FriendsSettingPresenter;
import com.chatty.android.chattyClient.presenter.main.MainPresenter;

import butterknife.ButterKnife;

public class FriendsSettingActivity extends AppCompatActivity {
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
  }
}
