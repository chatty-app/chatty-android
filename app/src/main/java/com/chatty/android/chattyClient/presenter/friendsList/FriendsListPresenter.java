package com.chatty.android.chattyClient.presenter.friendsList;

import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedPresenter;
import com.chatty.android.chattyClient.model.FriendItemEntry;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.state.action.PartnerAction;
import com.chatty.android.chattyClient.view.friendsList.FriendsListActivity;
import com.chatty.android.chattyClient.view.friendsList.FriendsListProps;

import java.util.ArrayList;

public class FriendsListPresenter implements ExtendedPresenter<State> {
  private FriendsListActivity view;
  public FriendsListPresenter(FriendsListActivity friendsListActivity) {
    this.view = friendsListActivity;
  }

  public void construct() {
    StateManagerWrapper.subscribe(this::stateListener);
    view.render();
    this.presenterDidMount();
  }

  public void presenterDidMount() {
    try {
      StateManagerWrapper.dispatch(PartnerAction.requestGetFriendsList());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object stateListener(State state) {
    StateManagerWrapper.log(this.getClass().getSimpleName(), state);

    FriendsListProps props = new FriendsListProps();
    props.friendsList = (ArrayList<FriendItemEntry>) state.getFriends();
    this.view.update(
      props
    );
    return null;
  }
}
