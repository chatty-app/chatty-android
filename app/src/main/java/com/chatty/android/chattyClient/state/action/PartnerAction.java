package com.chatty.android.chattyClient.state.action;

import android.util.Log;

import com.chatty.android.chattyClient.api.ChattyApi;
import com.chatty.android.chattyClient.constants.ActionType;
import com.chatty.android.chattyClient.externalModules.StateManager.Action;
import com.chatty.android.chattyClient.externalModules.StateManager.StateManager;
import com.chatty.android.chattyClient.model.PartnerProfileDetailEntry;
import com.chatty.android.chattyClient.model.response.PartnerProfileDetailResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartnerAction {
  public static StateManager.DispatcherMiddleware requestGetPartnerProfileDetail() {
    return (dispatch) -> {
      dispatch.run(new Action(ActionType.REQUEST_GET_PARTNER_PROFILE_DETAIL));

      ChattyApi.getApi().getPartnerProfileDetail(1)
        .enqueue(new Callback<PartnerProfileDetailResponse>() {
          @Override
          public void onResponse(Call<PartnerProfileDetailResponse> call, Response<PartnerProfileDetailResponse> response) {
//            TODO: new Parter에 매개변수가 call.getId 이런식으로 처리가 되어야 한다.
            PartnerProfileDetailEntry partnerProfile = new PartnerProfileDetailEntry(
              1,
              "https://img.geocaching.com/track/display/dec778cb-f0ff-4472-a020-27b9ba8aa4f4.jpg",
              "Homer. J. Simpsons",
              "Do'h!!!!!!!",
              10,
              14,
              "2018-07-21"
            );
            HashMap result = new HashMap<>();
            result.put("partnerProfileDetail", partnerProfile);
            dispatch.run(new Action(ActionType.REQUEST_GET_PARTNER_PROFILE_DETAIL_SUCCESS, result));
          }

          @Override
          public void onFailure(Call<PartnerProfileDetailResponse> call, Throwable t) {
            dispatch.run(new Action(ActionType.REQUEST_GET_PARTNER_PROFILE_DETAIL_ERROR));
          }
        });
    };
  }
}
