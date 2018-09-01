package com.chatty.android.chattyClient.presenter.friendsSetting;

import android.util.Log;

import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedPresenter;
import com.chatty.android.chattyClient.model.PartnerProfileDetailEntry;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.state.action.PartnerAction;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivity;

public class FriendsSettingPresenter implements ExtendedPresenter<State> {
  private FriendsSettingActivity view;

  public FriendsSettingPresenter(FriendsSettingActivity view) {
    this.view = view;
  }

  public void construct() {
    StateManagerWrapper.subscribe(this::stateListener);
    view.render();
    this.presenterDidMount();
  }

  public void presenterDidMount() {
    try {
      StateManagerWrapper.dispatch(PartnerAction.requestGetPartnerProfileDetail());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object stateListener(State state) {
    StateManagerWrapper.log(this.getClass().getSimpleName(), state);

    PartnerProfileDetailEntry partnerProfileDetail = state.getPartnerProfileDetail();
    view.renderPartnerProfile(partnerProfileDetail);
    return null;
  }
}
