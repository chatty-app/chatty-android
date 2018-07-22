package com.chatty.android.chattyClient.util;

import com.chatty.android.chattyClient.api.HomeworkApis;
import com.chatty.android.chattyClient.module.RetrofitClient;

public class ApiUtils {
  public static final String BASE_URL = "http://httpbin.org/";

  public static HomeworkApis getHomeworkApis() {
    return RetrofitClient.getClient(BASE_URL)
      .create(HomeworkApis.class);
  }
}
