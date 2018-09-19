package com.chatty.android.chattyClient.presenter.friendsSetting;

import android.os.Bundle;

import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedPresenter;
import com.chatty.android.chattyClient.model.PartnerProfileDetailEntry;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.state.action.PartnerAction;
import com.chatty.android.chattyClient.view.friendsList.FriendsListActivityProps;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivityProps;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivityState;

public class FriendsSettingPresenter
  extends ExtendedPresenter<FriendsSettingActivityProps, FriendsSettingActivityState, State> {

  @Override
  public FriendsSettingActivityProps initiate() {
    try {
      StateManagerWrapper.dispatch(PartnerAction.requestGetPartnerProfileDetail());
    } catch (Exception e) {
      e.printStackTrace();
    }

    FriendsSettingActivityProps props = new FriendsSettingActivityProps();
    props.friendDetail = StateManagerWrapper.getState().getPartnerProfileDetail();
    return props;
  }

  public FriendsSettingActivityProps stateListener(State state) {
    StateManagerWrapper.log(this.getClass().getSimpleName(), state);

    FriendsSettingActivityProps props = new FriendsSettingActivityProps();
    props.friendDetail = state.getPartnerProfileDetail();

    return props;
  }
}
