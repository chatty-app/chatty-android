package com.chatty.android.chattyClient.model.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimelineResponse {
  public Partner partner;
  public List<Diary> complete_diaries;

  public class Partner {
    public Integer days_together;
    public Integer diary_count;
    public String name;
    public Integer partner_id;
    public String profile_image;
  }
  
  public class Diary {
    public Integer diary_id;
    public Date created_at;
    public List<Answer> answers;
  }

  public class Answer {
    public Integer answer_id;
    public String image;
    public String label;
  }
}
