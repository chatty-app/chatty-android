package com.chatty.android.chattyClient.view.diaryDetail;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.externalModules.Renderer.Renderer;
import com.chatty.android.chattyClient.model.Diary;
import com.chatty.android.chattyClient.model.TimelineEntry;
import com.chatty.android.chattyClient.presenter.diaryDetail.DiaryAdapter;
import com.chatty.android.chattyClient.presenter.diaryDetail.DiaryDetailPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiaryDetailActivity extends AppCompatActivity {
  private DiaryDetailPresenter presenter;
  private static final String DIARY_TITLE = "Diary";

  @BindView(R.id.button_timeline_left)
  public ImageButton backButton;

  @BindView(R.id.profile_avatar_img)
  public ImageView profileAvatarImg;

  @BindView(R.id.textView_diary_partner_name)
  public TextView name;

  @BindView(R.id.textView_diary_date)
  public TextView date;

  @BindView(R.id.imageView_diary_weather)
  public ImageView weather;

  @BindView(R.id.imageView_diary_emotion)
  public ImageView emotions;

  @BindView(R.id.recyclerView_diary)
  public RecyclerView recyclerView;
  private DiaryAdapter diaryAdapter;

  private ArrayList<Diary> diaries;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.construct();

    initView();
  }

  private void construct() {
    setContentView(R.layout.item_diary_detail);
    ButterKnife.bind(this);

    presenter = new DiaryDetailPresenter(this);
    this.presenter.construct();
  }

  public void initRender(ArrayList<Diary> diaries) {

    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(DIARY_TITLE);

    this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    this.diaryAdapter = new DiaryAdapter(this, diaries);
    this.recyclerView.setAdapter(diaryAdapter);
  }
  public void initView() {
    diaries = new ArrayList<>();

    circleImageView();
    viewBackButton();
    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(DIARY_TITLE);
  }

  private void circleImageView() {
    this.profileAvatarImg.setBackground(new ShapeDrawable(new OvalShape()));
    this.profileAvatarImg.setClipToOutline(true);
  }

  public void render(
    ArrayList<Diary> diary
  ) {
    Renderer.render(
      this,
      Arrays.asList(diary),
      this::renderDiaryView);
  }

  private void renderDiaryView(Object diary) {
    this.diaryAdapter.update((List<Diary>) diary);
  }

  private void viewBackButton() {
    backButton.setOnClickListener(view -> {
      finish();
    });
  }

}
