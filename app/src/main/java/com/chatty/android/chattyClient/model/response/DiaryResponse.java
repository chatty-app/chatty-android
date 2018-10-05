package com.chatty.android.chattyClient.model.response;

import java.util.Date;
import java.util.List;

public class DiaryResponse {
  public List<Question> questions;
  public List<Answer> answers;
  public Partner partner;
  public String weather;
  public String feeling;
  public String create_at;

  public class Partner {
     public String profile_image;
     public String name;
  }

  public class Question {
    public int question_id;
    public String message;
  }

  public class Answer {
    public Date created_at;
    public String image;
    public String label;
    public int question;
  }
}
