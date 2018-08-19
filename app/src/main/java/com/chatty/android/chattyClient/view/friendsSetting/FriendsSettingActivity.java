package com.chatty.android.chattyClient.view.friendsSetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.model.PartnerProfileDetailEntry;
import com.chatty.android.chattyClient.presenter.friendsSetting.FriendsSettingPresenter;


import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsSettingActivity extends AppCompatActivity {
  private static String HEADER_TITLE = "Friends Setting";
  private FriendsSettingPresenter presenter;

  @BindView(R.id.button_timeline_left)
  public ImageButton imageButtonBack;

  @BindView(R.id.button_edit_profile)
  public Button buttonEditProfile;

  @BindView(R.id.imageView_profile)
  public ImageView imageViewProfileImage;

  @BindView(R.id.textView_profile_name)
  public TextView textViewProfileName;

  @BindView(R.id.textView_profile_bio)
  public TextView textViewProfileBio;

  @BindView(R.id.textView_profile_diary_answer)
  public TextView textViewProfileDiary;

  @BindView(R.id.textView_profile_during_answer)
  public TextView textViewProfileDuring;

  @BindView(R.id.textView_profile_startdate_answer)
  public TextView textViewProfileStartDate;

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
    renderHeader();
  }

  private void renderHeader() {
    setHeaderTitle();
    renderBackButton();
    renderEditProfileButton();
  }

  private void renderEditProfileButton() {
    buttonEditProfile.setOnClickListener((__) -> {
      Log.e("버튼 클릭", "다음 화면으로 이동!");
    });
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

  public void renderPartnerProfile(PartnerProfileDetailEntry partnerProfileDetail) {
    PartnerProfileDetailEntry currentPartnerProfileDetail = partnerProfileDetail;
//    TODO: Glide를 이용하여 ImageView 처리하가ㅣ
    textViewProfileName.setText(currentPartnerProfileDetail.getName());
    textViewProfileBio.setText(currentPartnerProfileDetail.getBio());
    textViewProfileDiary.setText(String.valueOf(currentPartnerProfileDetail.getDiaryCount()));
    textViewProfileDuring.setText(String.valueOf(currentPartnerProfileDetail.getDaysTogether()));
    textViewProfileStartDate.setText(currentPartnerProfileDetail.getCreateDate());
  }
}
