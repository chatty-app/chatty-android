package com.chatty.android.chattyClient.model.request;

public class ChatRequest {
  private String contents;

  public ChatRequest(String contents) {
    this.contents = contents;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }
}
