package com.chatty.android.chattyClient.view.addFriend;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedView;
import com.chatty.android.chattyClient.module.ImagePicker;
import com.chatty.android.chattyClient.presenter.addFriend.AddFriendPresenter;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivity;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gun0912.tedbottompicker.TedBottomPicker;

public class AddFriendActivity extends AppCompatActivity implements ExtendedView<AddFriendProps>, ImagePicker {
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
    this.setPermission();
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

  @Override
  public void setPermission() {
    PermissionListener permissionListener = new PermissionListener() {
      @Override
      public void onPermissionGranted() {
        initImagePicker();
      }

      @Override
      public void onPermissionDenied(List<String> deniedPermissions) {
        Toast.makeText(getApplicationContext(), "권한이 없습니다.", Toast.LENGTH_SHORT).show();
      }
    };
    TedPermission.with(getApplicationContext())
      .setPermissionListener(permissionListener)
      .setDeniedMessage("권한 설정 동의를 안하신다면, 나중에 이곳에서 설정해 주세요. [설정] > [권한]")
      .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
      .check();
  }

  @Override
  public void initImagePicker() {
    TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(getApplicationContext())
      .setOnImageSelectedListener(uri ->
        presenter.selectImage(uri)
      ).create();
  tedBottomPicker.show(getSupportFragmentManager());
  }

  public void updateProfile(Uri uri) {
    Glide.with(getApplicationContext())
      .load(uri)
      .into(this.imageViewProfile);
  }
}
