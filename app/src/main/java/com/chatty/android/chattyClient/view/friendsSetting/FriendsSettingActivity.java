package com.chatty.android.chattyClient.view.friendsSetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.presenter.friendsSetting.FriendsSettingPresenter;


import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsSettingActivity extends AppCompatActivity {
  private static String HEADER_TITLE = "Friends Setting";
  private FriendsSettingPresenter presenter;

  @BindView(R.id.button_timeline_left)
  public ImageButton imageButtonBack;

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
    setHeaderTitle();
    renderBackButton();
  }

  private void renderBackButton() {
    imageButtonBack.setOnClickListener((__) -> {
      finish();
    });
  }

  private void setHeaderTitle() {
    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(HEADER_TITLE);
  }
}
