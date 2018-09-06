package com.chatty.android.chattyClient.view.friendsList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedView;
import com.chatty.android.chattyClient.model.FriendItemEntry;
import com.chatty.android.chattyClient.presenter.addFriend.AddFriendPresenter;
import com.chatty.android.chattyClient.presenter.friendsList.FriendsListPresenter;
import com.chatty.android.chattyClient.presenter.friendsList.FriendsListRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendsListActivity extends AppCompatActivity implements ExtendedView<FriendsListProps>{
  private static String HEADER_TITLE = "Friends List";
  private FriendsListRecyclerViewAdapter friendsListRecyclerViewAdapter;
  FriendsListPresenter presenter;

  @BindView(R.id.button_timeline_left)
  public ImageButton imageButtonBack;

  @BindView(R.id.recyclerView_profile_list)
  public RecyclerView recyclerViewProfileList;

  @BindView(R.id.imageView_profile_now)
  public ImageView imageViewProfileNow;

  @BindView(R.id.textView_profile_name_now)
  public TextView textViewProfileNameNow;

  @BindView(R.id.textView_profile_bio_now)
  public TextView textViewProfileBioNow;

  @BindView(R.id.textView_profile_date_now)
  public TextView textViewProfileDateNow;

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

  private void renderProfileList(List<FriendItemEntry> _friendsList) {
    List<FriendItemEntry> friendsList = _friendsList;
    recyclerViewProfileList.setLayoutManager(new LinearLayoutManager(this));
    friendsListRecyclerViewAdapter = new FriendsListRecyclerViewAdapter(friendsList, getApplicationContext());
    recyclerViewProfileList.setAdapter(friendsListRecyclerViewAdapter);
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
    List<FriendItemEntry> friendsList = p.friendsList;
    this.renderProfileList(friendsList);
    if (friendsList.size() > 0 ) {
      FriendItemEntry friendItemEntry = p.friendsList.get(0);
      renderProfileNow(friendItemEntry);
    }
  }

  public void renderProfileNow(FriendItemEntry _friendItem) {
    FriendItemEntry friendItem = _friendItem;

    textViewProfileNameNow.setText(friendItem.getName());
    textViewProfileBioNow.setText(friendItem.getBio());
    textViewProfileDateNow.setText(friendItem.getCreated_at());
    String imageUrl = "http://13.125.168.50:1432" + friendItem.getProfile_image();
    Glide.with(getApplicationContext())
      .load(imageUrl)
      .into(this.imageViewProfileNow);
  }

}
