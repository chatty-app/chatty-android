package com.chatty.android.chattyClient.view.friendsList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedView;
import com.chatty.android.chattyClient.presenter.addFriend.AddFriendPresenter;
import com.chatty.android.chattyClient.presenter.friendsList.FriendsListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsListActivity extends AppCompatActivity implements ExtendedView<FriendsListProps>{
  private static String HEADER_TITLE = "Friends List";
  FriendsListPresenter presenter;

  @BindView(R.id.button_timeline_left)
  public ImageButton imageButtonBack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    construct();
  }

  private void construct() {
    setContentView(R.layout.activity_friends_list);
    ButterKnife.bind(this);
    presenter = new FriendsListPresenter(this);
    presenter.construct();
  }

  public void render() {
    this.renderHeader();
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
  public void initialRender(FriendsListProps p) {

  }

  @Override
  public void update(FriendsListProps p) {

  }

}
