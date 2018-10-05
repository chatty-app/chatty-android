package com.chatty.android.chattyClient.state.action;

import android.util.Log;

import com.chatty.android.chattyClient.api.ChattyApi;
import com.chatty.android.chattyClient.constants.ActionType;
import com.chatty.android.chattyClient.externalModules.ReduxJava.Action;
import com.chatty.android.chattyClient.externalModules.ReduxJava.ReduxJava;
import com.chatty.android.chattyClient.model.request.NewPartnerRequest;
import com.chatty.android.chattyClient.model.response.ChatResponse;
import com.chatty.android.chattyClient.model.response.FriendItemResponse;
import com.chatty.android.chattyClient.model.response.PartnerProfileDetailResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartnerAction {
  public static ReduxJava.DispatcherMiddleware requestGetPartnerProfileDetail() {
    return (dispatch) -> {
      dispatch.run(Action.of(ActionType.REQUEST_GET_PARTNER_PROFILE_DETAIL));
//      TODO: 현재 최신 유저만 받아올 수 있게 되어있음. 추후 USERLIST 클릭 시 해당 아이디를 통해서 처리를 해야함
//      ChattyApi.getApi().getPartnerProfileDetail(1)
        ChattyApi.getApi().getMyPartnerProfile()
        .enqueue(new Callback<PartnerProfileDetailResponse>() {
          @Override
          public void onResponse(
            Call<PartnerProfileDetailResponse> call,
            Response<PartnerProfileDetailResponse> response
          ) {
            PartnerProfileDetailResponse partnerProfile = response.body();
            dispatch.run(Action.of(ActionType.REQUEST_GET_PARTNER_PROFILE_DETAIL_SUCCESS)
              .payloadAdd("partnerProfileDetail", partnerProfile));
          }

          @Override
          public void onFailure(Call<PartnerProfileDetailResponse> call, Throwable t) {
            dispatch.run(Action.of(ActionType.REQUEST_GET_PARTNER_PROFILE_DETAIL_ERROR));
          }
        });
    };
  }

  public static ReduxJava.DispatcherMiddleware requestAddNewPartnerProfile(
    RequestBody name,
    RequestBody bio,
    MultipartBody.Part file) {
    return(dispatch) -> {
      dispatch.run(Action.of(ActionType.REQUEST_ADD_FRIEND));
      ChattyApi.getApi().postNewPartner(name, bio, file)
        .enqueue(new Callback<ChatResponse>() {
          @Override
          public void onResponse(
            Call<ChatResponse> call,
            Response<ChatResponse> response
          ) {
            Log.e("통신 성공", "통신 성공!!!");
            dispatch.run(Action.of(ActionType.REQUEST_ADD_FRIEND_SUCCESS)
              .payloadAdd("addFriend",true));
          }

          @Override
          public void onFailure(Call<ChatResponse> call, Throwable t) {
            Log.e("통신 실패", String.valueOf(t));
            dispatch.run(Action.of(ActionType.REQUEST_ADD_FRIEND_ERROR));
          }
        });
    };
  }

  private static PartnerProfileDetailResponse getDummyProfileDetail() {
    PartnerProfileDetailResponse partnerProfileDetailResponse = new PartnerProfileDetailResponse(
      1,
      "https://img.geocaching.com/track/display/dec778cb-f0ff-4472-a020-27b9ba8aa4f4.jpg",
      "Homer. J. Simpsons",
      "Do'h!!!!!!!",
      10,
      14,
      "2018-07-21"
    );

    return partnerProfileDetailResponse;
  }

  public static ReduxJava.DispatcherMiddleware requestGetFriendsList() {
    return (dispatch) -> {
      dispatch.run(Action.of(ActionType.REQUEST_GET_FRIENDS_LIST));
      ChattyApi.getApi().getFriendsList()
        .enqueue(new Callback<FriendItemResponse>() {
          @Override
          public void onResponse(Call<FriendItemResponse> call, Response<FriendItemResponse> response) {
            FriendItemResponse friendItemResponse = response.body();
            dispatch.run(Action.of(ActionType.REQUEST_GET_FRIENDS_LIST_SUCCESS)
              .payloadAdd("friendsList", friendItemResponse));
          }

          @Override
          public void onFailure(Call<FriendItemResponse> call, Throwable t) {
            dispatch.run(Action.of(ActionType.REQUEST_GET_FRIENDS_LIST_ERROR)
            .payloadAdd("error",t));

            Log.e("ERROR", String.valueOf(t));
          }
        });
    };
  }
}
