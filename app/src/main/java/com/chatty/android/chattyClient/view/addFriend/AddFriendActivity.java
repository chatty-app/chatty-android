package com.chatty.android.chattyClient.view.addFriend;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedView;
import com.chatty.android.chattyClient.module.ImagePicker;
import com.chatty.android.chattyClient.model.request.NewPartnerRequest;
import com.chatty.android.chattyClient.presenter.addFriend.AddFriendPresenter;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivity;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gun0912.tedbottompicker.TedBottomPicker;

public class AddFriendActivity extends AppCompatActivity implements ExtendedView<AddFriendActivityProps>, ImagePicker {
  private static String HEADER_TITLE = "Add Friend";
  private boolean isSubmitReady = false;
  AddFriendPresenter presenter;

  @BindView(R.id.button_timeline_left)
  public ImageButton imageButtonBack;

  @BindView(R.id.imageView_profile)
  public ImageView imageViewProfile;

  @BindView(R.id.imageView_addProfile_button)
  public ImageView imageViewAddProfileButton;

  @BindView(R.id.button_add_profile)
  public Button  buttonAddProfile;

  @BindView(R.id.editText_profile_name)
  public EditText editTextProfileName;

  @BindView(R.id.editText_profile_bio)
  public EditText editTextProfileBio;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_add_friend);
    ButterKnife.bind(this);
    this.presenter = new AddFriendPresenter(this);
  }

  @Override
  public void initialRender(AddFriendActivityProps p) {
    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(HEADER_TITLE);

    this.imageButtonBack.setOnClickListener(
      p.handleClickImageButtonBack.apply(this::finish));

    this.imageViewProfile.setOnClickListener(
      p.handleClickImageViewProfile.apply(() -> {}));

    this.imageViewAddProfileButton.setOnClickListener(
      p.handleClickImageViewProfile.apply(() -> {}));

    this.buttonAddProfile.setOnClickListener(
      p.handleClickButtonAddProfile.apply(this));
  }

  private void profileImageButtonAction() {
    this.setPermission();
  }


  @Override
  public void update(AddFriendActivityProps p) {

  }

  public void activateSubmitButton(boolean isSubmitReady) {
    this.isSubmitReady = isSubmitReady;
    if(this.isSubmitReady) {
      buttonAddProfile.setBackgroundResource(R.color.main_purple);
    } else {
      buttonAddProfile.setBackgroundResource(R.color.gray5);
    }
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
