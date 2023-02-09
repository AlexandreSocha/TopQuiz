package com.alexcorp.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alexcorp.topquiz.R;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private Button mReponse1Button;
    private Button mReponse2Button;
    private Button mReponse3Button;
    private Button mReponse4Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mQuestionTextView.findViewById(R.id.game_activity_textview_question);
        mReponse1Button.findViewById(R.id.game_activity_button_1);
        mReponse2Button.findViewById(R.id.game_activity_button_2);
        mReponse3Button.findViewById(R.id.game_activity_button_3);
        mReponse4Button.findViewById(R.id.game_activity_button_4);
    }
}