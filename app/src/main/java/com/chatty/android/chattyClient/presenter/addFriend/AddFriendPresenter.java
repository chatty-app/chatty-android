package com.chatty.android.chattyClient.presenter.addFriend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.chatty.android.chattyClient.App;
import com.chatty.android.chattyClient.externalModules.AndroidExtended.ExtendedPresenter;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.model.request.NewPartnerRequest;
import com.chatty.android.chattyClient.module.StateManagerWrapper;
import com.chatty.android.chattyClient.state.action.DiaryAction;
import com.chatty.android.chattyClient.state.action.PartnerAction;
import com.chatty.android.chattyClient.view.addFriend.AddFriendActivity;
import com.chatty.android.chattyClient.view.addFriend.AddFriendActivityProps;
import com.chatty.android.chattyClient.view.friendsSetting.FriendsSettingActivity;

import java.util.function.Supplier;

import okhttp3.MultipartBody;

public class AddFriendPresenter implements ExtendedPresenter<State> {
  private AddFriendActivityProps props;

  public AddFriendPresenter(AddFriendActivity addFriendActivity) {
    StateManagerWrapper.subscribe(this::stateListener);
    this.props = new AddFriendActivityProps();
    props.handleClickImageButtonBack = this::handleClickImageButtonBack;
    props.handleClickImageViewProfile = this::handleClickImageViewProfile;
    props.handleClickButtonAddProfile = this::handleClickButtonAddProfile;

    addFriendActivity.initialRender(props);
  }

  private View.OnClickListener handleClickButtonAddProfile(Runnable r) {
    return (v) -> r.run();
  }

  public Object stateListener(State state) {
    return null;
  }

  private View.OnClickListener handleClickImageButtonBack(Runnable r) {
    return (v) -> r.run();
  }

  private View.OnClickListener handleClickImageViewProfile(Runnable r) {
    Log.v("동작", "동작완료");
    return (v) -> r.run();
  }

  private View.OnClickListener handleClickButtonAddProfile(AddFriendActivity activity) {
    return (v) -> {
      String currentName = activity.editTextProfileName.getText().toString();
      String currentBio = activity.editTextProfileBio.getText().toString();
      NewPartnerRequest currentNewPartner = new NewPartnerRequest(currentName, currentBio);
      boolean hasFreind = StateManagerWrapper.getState().hasFriend;
      activity.startActivity(new Intent(activity, FriendsSettingActivity.class));
    };
  }
}
