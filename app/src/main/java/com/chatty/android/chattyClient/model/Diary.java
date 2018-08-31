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

  public Diary (String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  /*public String getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getWeather() {
    return weather;
  }

  public void setWeather(Date date) {
    this.weather = weather;
  }

  public Date getEmotion() {
    return emotion;
  }

  public void setEmotion(Date date) {
    this.emotion = emotion;
  }*/

  public String getQuestion() { return question;}

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
