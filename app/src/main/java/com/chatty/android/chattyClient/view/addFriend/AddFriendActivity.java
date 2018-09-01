package com.chatty.android.chattyClient.view.addFriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedView;
import com.chatty.android.chattyClient.presenter.addFriend.AddFriendPresenter;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFriendActivity extends AppCompatActivity implements ExtendedView<AddFriendProps> {
  private static String HEADER_TITLE = "Add Friend";
  AddFriendPresenter presenter;

  @BindView(R.id.button_timeline_left)
  public ImageButton imageButtonBack;

  @BindView(R.id.imageView_profile)
  public ImageView imageViewProfile;

  @BindView(R.id.imageView_addProfile_button)
  public ImageView imageViewAddProfileButton;

  @BindView(R.id.button_add_profile)
  public Button  buttonAddProfile;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    construct();
  }

  private void construct() {
    this.setContentView(R.layout.activity_add_friend);
    ButterKnife.bind(this);
    presenter = new AddFriendPresenter(this);
    presenter.construct();
  }

  public void render() {
    this.renderHeader();
    this.renderForm();
  }

  private void renderForm() {
    this.renderProfileImage();
  }

  private void renderProfileImage() {
    this.profileImageButtonManager();
    this.profileSubmitButtonManager();
  }

  private void profileSubmitButtonManager() {
    this.buttonAddProfile.setOnClickListener((__) -> {
      presenter.setIsFriend();
      this.startFriendsSettingActivity();
    });
  }

  private void startFriendsSettingActivity() {
    this.startActivity(new Intent(this, FriendsSettingActivity.class));
    finish();
  }

  private void profileImageButtonManager() {
    this.imageViewProfile.setOnClickListener((__) -> {
      this.profileImageButtonAction();
    });
    this.imageViewAddProfileButton.setOnClickListener((__) -> {
      this.profileImageButtonAction();
    });
  }

  private void profileImageButtonAction() {
    Log.v("동작", "동작완료");
  }

  private void renderHeader() {
    this.setHeaderTitle();
    this.renderBackButton();
  }

  private void setHeaderTitle() {
    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(HEADER_TITLE);
  }

  private void renderBackButton() {
    this.imageButtonBack.setOnClickListener((__) -> {
      finish();
    });
  }

  @Override
  public void initialRender(AddFriendProps p) {

  }

  @Override
  public void update(AddFriendProps p) {

  }
}
