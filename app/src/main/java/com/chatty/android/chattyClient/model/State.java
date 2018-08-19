package com.chatty.android.chattyClient.model;

import java.util.ArrayList;

public class State {
  PartnerProfileDetailEntry partnerProfileDetail;
  ArrayList<TimelineEntry> timeline;

  public State() {
    this.partnerProfileDetail = new PartnerProfileDetailEntry();
    this.timeline = new ArrayList<>();
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

  public void setTimeline(ArrayList<TimelineEntry> timeline) {
    this.timeline = timeline;
  }

  public State clone() {
    State instance = new State();
    instance.timeline = this.timeline;
    return instance;
  }
}
