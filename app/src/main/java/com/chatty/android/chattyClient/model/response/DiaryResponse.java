package com.chatty.android.chattyClient.model.response;

import java.util.Date;

public class DiaryResponse {
  public Question question;
  public Anwers answer;
  private Question entry = new Question();
  private Anwers request = new Anwers();

  public DiaryResponse (String message, String answer) {
    entry.message = message;
    request.answer = answer;
  }

  public class Question {
    String message;
    Integer id;
  }

  public class Anwers {
    Integer question;
    String answer;
    Date image;
    Date created_at;
  }

  public Integer getId() { return entry.id; }

  public void setId(Integer id) { entry.id = id; }

  public String getMessage(){ return entry.message; }

  public void setMessage(String message) { entry.message = message; }

  public Integer getQuestion() { return request.question; }

  public void setQuestion(Integer question) { request.question = question; }

  public String getAnswer() { return request.answer; }

  public void setAnswer(String answer) { request.answer = answer; }

  public Date getImage() { return request.image; }

  public void setImage(Date image) { request.image = image; }

  public Date getCreated_at() { return request.created_at; }

  public void setCreated_at(Date created_at) { request.created_at = created_at; }
}
