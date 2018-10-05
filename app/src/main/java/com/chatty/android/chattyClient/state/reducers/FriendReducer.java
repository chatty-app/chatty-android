package com.chatty.android.chattyClient.state.reducers;

import android.util.Log;

import com.chatty.android.chattyClient.constants.ActionType;
import com.chatty.android.chattyClient.externalModules.ReduxJava.Action;
import com.chatty.android.chattyClient.externalModules.ReduxJava.Reducer;
import com.chatty.android.chattyClient.model.FriendItemEntry;
import com.chatty.android.chattyClient.model.Partner;
import com.chatty.android.chattyClient.model.PartnerProfileDetailEntry;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.model.response.FriendItemResponse;
import com.chatty.android.chattyClient.model.response.PartnerProfileDetailResponse;
import com.chatty.android.chattyClient.model.response.TimelineResponse;

import java.util.ArrayList;
import java.util.List;

public class FriendReducer implements Reducer<State.Friend> {
  @Override
  public State.Friend run(State.Friend friend, Action action) {
    switch (action.getType()) {
      case ActionType.REQUEST_GET_DIARIES_SUCCESS:
        TimelineResponse timelineResponse = (TimelineResponse) action.getPayload().get("timeline");

        Partner partner = new Partner();
        partner.diary_count = timelineResponse.partner.diary_count;
        partner.days_together = timelineResponse.partner.days_together;
        partner.imageUrl = timelineResponse.partner.profile_image;
        partner.name = timelineResponse.partner.name;
        friend.partner = partner;
        return friend;

      case ActionType.REQUEST_GET_PARTNER_PROFILE_DETAIL_SUCCESS:
        PartnerProfileDetailResponse partnerProfileDetailResponse = (PartnerProfileDetailResponse) action.getPayload().get("partnerProfileDetail");
        PartnerProfileDetailEntry partnerProfileDetailEntry = makePartnerProfile(partnerProfileDetailResponse);
        friend.partnerProfileDetail = partnerProfileDetailEntry;
        return friend;

      case ActionType.REQUEST_GET_FRIENDS_LIST_SUCCESS:
        FriendItemResponse friendItemResponse = (FriendItemResponse) action.getPayload().get("friendsList");
        ArrayList<FriendItemEntry> friends = makeFriendList(friendItemResponse.getFriendItems());
        friend.friends = friends;
        return friend;

      case ActionType.REQUEST_ADD_FRIEND_SUCCESS:
        boolean isAddFriend = (boolean) action.getPayload().get("addFriend");
        friend.isAddFriend = isAddFriend;
        return friend;
      default:
        return friend;
    }
  }

  private ArrayList<FriendItemEntry> makeFriendList(List<FriendItemResponse.Partner> friendItems) {
    ArrayList<FriendItemEntry> friends = new ArrayList<>();

    for (FriendItemResponse.Partner currentFriend : friendItems) {
      friends.add(
        new FriendItemEntry(
          currentFriend.profile_image,
          currentFriend.name,
          currentFriend.bio,
          currentFriend.created_at
        )
      );
    }

    return friends;
  }

  private static PartnerProfileDetailEntry makePartnerProfile(PartnerProfileDetailResponse partnerProfileDetailResponse) {
    PartnerProfileDetailEntry partnerProfileDetailEntry = new PartnerProfileDetailEntry(
      partnerProfileDetailResponse.getId(),
      partnerProfileDetailResponse.getProfileImage(),
      partnerProfileDetailResponse.getName(),
      partnerProfileDetailResponse.getBio(),
      partnerProfileDetailResponse.getDiaryCount(),
      partnerProfileDetailResponse.getDaysTogether(),
      partnerProfileDetailResponse.getCreateDate()
    );
    return partnerProfileDetailEntry;
  }
}
