package com.chatty.android.chattyClient.presenter.friendsList;

import android.os.Bundle;

import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedPresenter;
import com.chatty.android.chattyClient.model.FriendItemEntry;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.state.action.PartnerAction;
import com.chatty.android.chattyClient.view.friendsList.FriendsListActivityProps;
import com.chatty.android.chattyClient.view.friendsList.FriendsListActivityState;

import java.util.ArrayList;

public class FriendsListPresenter extends ExtendedPresenter<FriendsListActivityProps, FriendsListActivityState, State> {
  @Override
  public FriendsListActivityProps initiate() {
    try {
      StateManagerWrapper.dispatch(PartnerAction.requestGetFriendsList());
    } catch (Exception e) {
      e.printStackTrace();
    }

    FriendsListActivityProps props = new FriendsListActivityProps();
    props.friendsList = StateManagerWrapper.getState().getFriends();
    return props;
  }

  @Override
  public FriendsListActivityProps stateListener(State state) {
    StateManagerWrapper.log(this.getClass().getSimpleName(), state);

    FriendsListActivityProps props = new FriendsListActivityProps();
    props.friendsList = state.getFriends();
    return props;
  }
}
