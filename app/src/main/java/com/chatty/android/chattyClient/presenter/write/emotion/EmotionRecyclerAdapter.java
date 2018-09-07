package com.chatty.android.chattyClient.presenter.write.emotion;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.model.response.Emotion;

import java.util.ArrayList;

public class EmotionRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private int getNum=0;

  public static class MyViewHolder extends RecyclerView.ViewHolder {
  ImageView emotionImage;
  TextView emotionText;

  MyViewHolder(View view){
    super(view);
    emotionImage = view.findViewById(R.id.image_emotion_recycler_view);
    emotionText = view.findViewById(R.id.text_emotion_recycler_view);
  }
}

  private ArrayList<Emotion> emotionArrayList;
  public EmotionRecyclerAdapter(ArrayList<Emotion> foodInfoArrayList){
    this.emotionArrayList = foodInfoArrayList;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emotion_recycler_view, parent, false);
    return new MyViewHolder(v);
  }

  @SuppressLint("ResourceAsColor")
  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    MyViewHolder myViewHolder = (MyViewHolder) holder;

    myViewHolder.emotionImage.setImageResource(emotionArrayList.get(position).emotionId);
    myViewHolder.emotionText.setText(emotionArrayList.get(position).emotionName);
    myViewHolder.emotionImage.setOnClickListener(view -> {
      if(getNum == 0) {
        Log.e("1111",emotionArrayList.get(position).emotionName);
        myViewHolder.emotionImage.setBackgroundResource(R.drawable.layout_emotion_back_circle);
        myViewHolder.emotionText.setTextColor(R.color.main_purple);
        getNum++;
      } else {
//          imageView.setTint(R.color.black0);
//          selectText.name(R.color.black5);
//          myViewHolder.emotionText.setTextColor(R.color.black0);
//          ColorDrawable colorDrawable = new ColorDrawable(selectText, R.color.black5);
      }
//        imageView= myViewHolder.emotionImage.getDrawable();
//        selectText= myViewHolder.emotionText.getCompoundDrawableTintMode();
//        imageView.setTint(R.drawable.layout_emotion_back_circle);
    });
  }
  @Override
  public int getItemCount() {
    return emotionArrayList.size();
  }

}
