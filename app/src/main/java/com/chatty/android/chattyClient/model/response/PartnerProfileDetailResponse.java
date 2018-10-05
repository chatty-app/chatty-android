package com.chatty.android.chattyClient.model.response;

public class PartnerProfileDetailResponse {
  public int id;
  public String profile_image;
  public String name;
  public String bio;
  public int diary_count;
  public int days_together;
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
    this.diary_count = diaryCount;
    this.days_together = daysTogether;
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
    return diary_count;
  }

  public void setDiaryCount(int diaryCount) {
    this.diary_count = diaryCount;
  }

  public int getDaysTogether() {
    return days_together;
  }

  public void setDaysTogether(int daysTogether) {
    this.days_together = daysTogether;
  }

  public String getCreateDate() {
    return created_at;
  }

  public void setCreateDate(String createDate) {
    this.created_at = createDate;
  }
}
