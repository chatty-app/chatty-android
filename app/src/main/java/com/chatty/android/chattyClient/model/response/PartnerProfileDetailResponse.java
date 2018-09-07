package com.chatty.android.chattyClient.model.response;

public class PartnerProfileDetailResponse {
  public int id;
  public String profile_image;
  public String name;
  public String bio;
  public int diaryCount;
  public int daysTogether;
  public String created_at;

  public PartnerProfileDetailResponse(
    int id,
    String profileImage,
    String name,
    String bio,
    int diaryCount,
    int daysTogether,
    String createDate
  ) {
    this.id = id;
    this.profile_image = profileImage;
    this.name = name;
    this.bio = bio;
    this.diaryCount = diaryCount;
    this.daysTogether = daysTogether;
    this.created_at = createDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProfileImage() {
    return profile_image;
  }

  public void setProfileImage(String profileImage) {
    this.profile_image = profileImage;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public int getDiaryCount() {
    return diaryCount;
  }

  public void setDiaryCount(int diaryCount) {
    this.diaryCount = diaryCount;
  }

  public int getDaysTogether() {
    return daysTogether;
  }

  public void setDaysTogether(int daysTogether) {
    this.daysTogether = daysTogether;
  }

  public String getCreateDate() {
    return created_at;
  }

  public void setCreateDate(String createDate) {
    this.created_at = createDate;
  }
}
