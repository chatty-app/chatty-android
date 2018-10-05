package com.chatty.android.chattyClient.view.addFriend;

import android.Manifest;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chatty.android.chattyClient.App;
import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedView;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.Props;
import com.chatty.android.chattyClient.model.request.NewPartnerRequest;
import com.chatty.android.chattyClient.module.ImagePicker;
import com.chatty.android.chattyClient.presenter.Contract;
import com.chatty.android.chattyClient.presenter.addFriend.AddFriendPresenter;
import com.chatty.android.chattyClient.state.Store;
import com.chatty.android.chattyClient.state.action.PartnerAction;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gun0912.tedbottompicker.TedBottomPicker;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AddFriendActivity extends AppCompatActivity implements ExtendedView<AddFriendActivityProps>, ImagePicker {
  private static String HEADER_TITLE = "Add Friend";
  private Uri imageUri;
  private boolean hasName = false;
  private boolean hasProfile = false;
  private boolean isSubmitReady = false;

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

  private AddFriendActivityProps props;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Contract.connect(this, AddFriendPresenter.class);
  }

  @Override
  public void initialRender(AddFriendActivityProps p) {
    this.setContentView(R.layout.activity_add_friend);
    ButterKnife.bind(this);

    this.props = p;
    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(HEADER_TITLE);

    this.imageButtonBack.setOnClickListener(
      this.props.handleClickImageButtonBack.apply(this::finish));

    this.imageViewProfile.setOnClickListener(
      this.props.handleClickImageViewProfile.apply(() -> {
        this.profileImageButtonAction();
      }));

    this.imageViewAddProfileButton.setOnClickListener(
      this.props.handleClickImageViewProfile.apply(() -> {
        this.profileImageButtonAction();
      }));

    this.buttonAddProfile.setOnClickListener(
      this.props.handleClickButtonAddProfile.apply(() -> {
        if (isSubmitReady) {
          this.sendProfileAction();
        }
      }));

    this.editTextProfileName.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        updateSubmitButton();
      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.toString().length() >0) {
          hasName = true;
        } else {
          hasName = false;
        }
      }

      @Override
      public void afterTextChanged(Editable editable) {
      }
    });
  }

  @Override
  public void update(AddFriendActivityProps props) {
    if (props.isAddFriend) {
      new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
          finish();
        }
      }, 500);
    }
  }

  private void sendProfileAction() {
    this.setFriendData();
    this.saveUserLocalData();
    finish();
  }

  private void setFriendData() {
    this.props.friendName = editTextProfileName.getText().toString();
    this.props.friendBio = editTextProfileBio.getText().toString();
    this.props.friendImage = new File (imageUri.getPath());
    RequestBody currentImage = RequestBody.create(MediaType.parse("multipart/*"), this.props.friendImage);
    MultipartBody.Part requestImage = MultipartBody.Part.createFormData("profile_image", this.props.friendImage.getName(), currentImage);
    RequestBody requestName = RequestBody.create(MediaType.parse("text/plain"), this.props.friendName);
    RequestBody requestBio = RequestBody.create(MediaType.parse("text/plain"), this.props.friendBio + "");

    Store.dispatch(PartnerAction.requestAddNewPartnerProfile(
      requestName,
      requestBio,
      requestImage
    ));
  }

  private void saveUserLocalData() {
    SharedPreferences userPreference = getSharedPreferences(App.USER_DATA, MODE_PRIVATE);
    SharedPreferences.Editor editor = userPreference.edit();
    editor.putBoolean(App.HAS_FRIEND, true);
    editor.commit();
  }

  private void profileImageButtonAction() {
    this.setPermission();
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
        Toast.makeText(getApplicationContext(), "권한이 없습니다.", Toast.LENGTH_SHORT)
          .show();
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
      .setOnImageSelectedListener(uri -> updateProfile(uri))
      .create();
    tedBottomPicker.show(getSupportFragmentManager());
  }

  public void updateProfile(Uri uri) {
    this.hasProfile = true;
    this.imageUri = uri;
    Glide.with(getApplicationContext())
      .load(this.imageUri)
      .into(this.imageViewProfile);
    updateSubmitButton();
  }

  private void updateSubmitButton() {
    if (hasProfile && hasName) {
      isSubmitReady = true;
      buttonAddProfile.setBackgroundResource(R.color.main_purple);
    } else {
      isSubmitReady = false;
      buttonAddProfile.setBackgroundResource(R.color.gray1);
    }
  }
}
