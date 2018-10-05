package com.chatty.android.chattyClient.model;

import com.chatty.android.chattyClient.model.response.DiaryResponse;

import java.util.ArrayList;

public class Diary extends ArrayList<Diary> {
/*  private String profileImage;
  private String username;
  private String date;
  private String weather;
  private Date emotion;*/
  private String question;
  private String answer;
  private String imageUrl;
  public String partners;
  public String weather;

  public Diary(String question, String answer, String imageUrl) {
    this.question = question;
    this.answer = answer;
    this.imageUrl = imageUrl;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
