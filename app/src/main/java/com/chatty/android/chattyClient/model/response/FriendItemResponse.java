package com.chatty.android.chattyClient.model.response;

import java.util.List;

public class FriendItemResponse {
  public List<Partner> partners;

  public List<Partner> getFriendItems() {
    return partners;
  }

  public class Partner {
    public String profile_image;
    public String name;
    public String bio;
    public String created_at;
  }
}
