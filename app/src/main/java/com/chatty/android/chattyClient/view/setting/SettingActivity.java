package com.chatty.android.chattyClient.view.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.setting.SettingPresenter;

import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {
  private SettingPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    construct();
  }

  private void construct() {
    setContentView(R.layout.activity_setting);
    ButterKnife.bind(this);
    presenter = new SettingPresenter(this);
    presenter.construct();
  }

  public void render() {
  }
}
