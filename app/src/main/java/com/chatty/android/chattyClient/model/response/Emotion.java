package com.chatty.android.chattyClient.model.response;

import android.widget.ImageView;

public class Emotion {
  public Integer emotionId;
  public String emotionName;

  public Emotion(Integer emotionId, String emotionName) {
    this.emotionId = emotionId;
    this.emotionName = emotionName;
  }

  public Integer getEmotionId() {
    return emotionId;
  }

  public void setEmotionId(Integer emotionId) {
    this.emotionId = emotionId;
  }

  public String getEmotionName() {
    return emotionName;
  }

  public void setEmotionName(String emotionName) {
    this.emotionName = emotionName;
  }
}
