package com.chatty.android.chattyClient.view.write;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.model.ChatBalloon;
import com.chatty.android.chattyClient.presenter.write.DialogueAdapter;
import com.chatty.android.chattyClient.presenter.write.WritePresenter;
import com.chatty.android.chattyClient.view.write.emotion.EmotionActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteActivity extends AppCompatActivity{
  private WritePresenter presenter;
  private static final String WRITE_TITLE = "Write";

  @BindView(R.id.button_timeline_left)
  public ImageButton backButton;

  @BindView(R.id.button_timeline_right)
  public ImageButton doneButton;

  @BindView(R.id.recyclerView_dialogue)
  public RecyclerView recyclerView;
  public RecyclerView.Adapter dialogueAdapter;

  @BindView(R.id.editText_writeInput)
  public EditText writeInputEditText;

  @BindView(R.id.button_writeSubmit)
  public Button writeSubmitButton;

  public List<ChatBalloon> chatBalloons;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

//    StateManager.dispatch(new Action("yo", null));
    construct();
  }

  private void construct() {
    setContentView(R.layout.activity_write);
    loadDependencies();
    presenter.init();
    render();

    TextView textView = findViewById(R.id.textView_timeline_title);
    textView.setText(WRITE_TITLE);

    doneButton.setImageResource(R.drawable.ic_icon_done);
  }

  private void loadDependencies() {
    presenter = new WritePresenter(this);
    ButterKnife.bind(this);
  }

  public void initView() {
    chatBalloons = new ArrayList<>();

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    dialogueAdapter = new DialogueAdapter(getApplicationContext(), chatBalloons);
    recyclerView.setAdapter(dialogueAdapter);

    writeSubmitButton.setOnClickListener(presenter.handleClickWriteSubmit());
  }

  public void appendChatBalloon(ChatBalloon chatBalloon) {
    this.chatBalloons.add(chatBalloon);
    this.dialogueAdapter.notifyItemInserted(this.chatBalloons.size() - 1);

    recyclerView.scrollToPosition(this.chatBalloons.size() -1);
  }

  public void render() {
    renderBackButton();
  }

  private void renderBackButton() {
    backButton.setOnClickListener(view -> {
      finish();
    });
    this.doneButton.setOnClickListener((view) -> {
      Intent intent = new Intent(this, EmotionActivity.class);
      startActivity(intent);
    });
  }
}

