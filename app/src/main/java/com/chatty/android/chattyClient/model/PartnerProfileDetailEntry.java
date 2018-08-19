package com.chatty.android.chattyClient.model;

public class PartnerProfileDetailEntry {
  public int id;
  public String profileImage;
  public String name;
  public String bio;
  public int diaryCount;
  public int daysTogether;
  public String createDate;

  public PartnerProfileDetailEntry() {
  }

  public PartnerProfileDetailEntry(
    int id,
    String profileImage,
    String name,
    String bio,
    int diaryCount,
    int daysTogether,
    String createDate
  ) {
    this.id = id;
    this.profileImage = profileImage;
    this.name = name;
    this.bio = bio;
    this.diaryCount = diaryCount;
    this.daysTogether = daysTogether;
    this.createDate = createDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
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
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }
}
