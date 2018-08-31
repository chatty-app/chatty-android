package com.chatty.android.chattyClient.model;

import com.chatty.android.chattyClient.model.response.DiaryResponse;

import java.util.ArrayList;

public class State {
  PartnerProfileDetailEntry partnerProfileDetail;
  ArrayList<TimelineEntry> timeline;
  ArrayList<Diary> diary;

  public State() {
    this.partnerProfileDetail = new PartnerProfileDetailEntry();
    this.timeline = new ArrayList<>();
    this.diary = new ArrayList<>();
  }

  public PartnerProfileDetailEntry getPartnerProfileDetail() {
    return partnerProfileDetail;
  }

  public void setPartnerProfileDetail(PartnerProfileDetailEntry partnerProfileDetail) {
    this.partnerProfileDetail = partnerProfileDetail;
  }

  public ArrayList<TimelineEntry> getTimeline() {
    return timeline;
  }

  public ArrayList<Diary> getDiary() {
    return diary;
  }

  public void setTimeline(ArrayList<TimelineEntry> timeline) { this.timeline = timeline;}
  public void setDiary(ArrayList<Diary> diary) { this.diary = diary;}

  public State clone() {
    State instance = new State();
    instance.timeline = this.timeline;
    instance.diary = this.diary;
    return instance;
  }

}
