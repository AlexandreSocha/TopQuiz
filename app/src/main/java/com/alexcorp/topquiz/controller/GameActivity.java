package com.alexcorp.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alexcorp.topquiz.R;
import com.alexcorp.topquiz.model.Question;
import com.alexcorp.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private Button mReponse1Button;
    private Button mReponse2Button;
    private Button mReponse3Button;
    private Button mReponse4Button;

    private QuestionBank mQuestionBank = generateQuestions();

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

    private QuestionBank generateQuestions(){
        Question question1 = new Question(
                "Who is the creator of Android?",
                Arrays.asList(
                        "Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"
                ),
                0
        );

        Question question2 = new Question(
                "When did the first man land on the moon?",
                Arrays.asList(
                        "1958",
                        "1962",
                        "1967",
                        "1969"
                ),
                3
        );

        Question question3 = new Question(
                "What is the house number of The Simpsons?",
                Arrays.asList(
                        "42",
                        "101",
                        "666",
                        "742"
                ),
                3
        );

        return new QuestionBank(Arrays.asList(question1, question2, question3));
    }

    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
    }
}