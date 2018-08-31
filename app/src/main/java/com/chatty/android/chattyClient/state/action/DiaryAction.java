package com.chatty.android.chattyClient.state.action;

import android.util.Log;

import com.chatty.android.chattyClient.api.ChattyApi;
import com.chatty.android.chattyClient.constants.ActionType;
import com.chatty.android.chattyClient.model.Diary;
import com.chatty.android.chattyClient.model.State;
import com.chatty.android.chattyClient.model.TimelineEntry;
import com.chatty.android.chattyClient.model.response.ChatResponse;
import com.chatty.android.chattyClient.externalModules.StateManager.Action;
import com.chatty.android.chattyClient.externalModules.StateManager.StateManager;
import com.chatty.android.chattyClient.model.response.DiaryResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Callback;
import retrofit2.Response;

public class DiaryAction {

  public static StateManager.DispatcherMiddleware requestGetDiaries() {
    return (dispatch) -> {
      dispatch.run(new Action(ActionType.REQUEST_GET_DIARIES));

      ChattyApi.getApi().postInitChat()
        .enqueue(new Callback<ChatResponse>() {
          @Override
          public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
            ArrayList<TimelineEntry> dummyEntries = new ArrayList<>();
            TimelineEntry dummyEntry1 = new TimelineEntry(
              "https://cdn1.medicalnewstoday.com/content/images/headlines/271/271157/bananas.jpg",
              new Date(),
              "dummy1"
            );

            TimelineEntry dummyEntry2 = new TimelineEntry(
              "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Pineapple_and_cross_section.jpg/220px-Pineapple_and_cross_section.jpg",
              new Date(),
              "dummy2"
            );

            dummyEntries.addAll(Arrays.asList(dummyEntry1, dummyEntry2));


            HashMap result = new HashMap<>();
            result.put("timeline", dummyEntries);
            dispatch.run(new Action(ActionType.REQUEST_GET_DIARIES_SUCCESS, result));
          }

          @Override
          public void onFailure(Call<ChatResponse> call, Throwable t) {
            System.out.println("123123" + t.getCause());
            dispatch.run(new Action(ActionType.REQUEST_GET_DIARIES_ERROR));
          }
        });
    };
  }

  public static StateManager.DispatcherMiddleware requestGetDiaryDetail() {
    return (dispatch) -> {
      dispatch.run(new Action(ActionType.REQUEST_GET_DIARIES_DETAIL));

      ChattyApi.getApi().postDiaryChat(1)
        .enqueue(new Callback<DiaryResponse>() {
          @Override
          public void onResponse(Call<DiaryResponse> call, Response<DiaryResponse> response) {
            ArrayList<DiaryResponse> dummyEntries = new ArrayList<>();

            DiaryResponse dummy1 = new DiaryResponse("dummy", "pretty good. I had study session with friends from mashup. \n" +
              "I learned how to make a random chatbot!!!!!!!!\n" +
              "It was really basic but still i had fun today cuz it&apos;s been a while since i learned sth new and fun.;sd");
            DiaryResponse dummy2 = new DiaryResponse("Hellow java?2", "Ths is my answer2");
            DiaryResponse dummy3 = new DiaryResponse("Hellow java?33", "Ths is my answer3");

            dummyEntries.addAll(Arrays.asList(dummy1, dummy2, dummy3));

            HashMap result = new HashMap<>();
            result.put("diary", dummyEntries);
            dispatch.run(new Action(ActionType.REQUEST_GET_DIARIES_DETAIL_SUCCESS, result));
          }

          @Override
          public void onFailure(Call<DiaryResponse> call, Throwable t) {
            dispatch.run(new Action(ActionType.REQUEST_GET_DIARIES_DETAIL_ERROR));
          }
        });
    };
  }
}
