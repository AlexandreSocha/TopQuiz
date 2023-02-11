package com.alexcorp.topquiz.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alexcorp.topquiz.R;
import com.alexcorp.topquiz.model.Question;
import com.alexcorp.topquiz.model.QuestionBank;

import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mReponse1Button;
    private Button mReponse2Button;
    private Button mReponse3Button;
    private Button mReponse4Button;



    private QuestionBank mQuestionBank = generateQuestions();
    private Question mCurrentQuestion;
    private int mRemainingQuestionCount;
    private int mScore;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionTextView.findViewById(R.id.game_activity_textview_question);
        mReponse1Button.findViewById(R.id.game_activity_button_1);
        mReponse2Button.findViewById(R.id.game_activity_button_2);
        mReponse3Button.findViewById(R.id.game_activity_button_3);
        mReponse4Button.findViewById(R.id.game_activity_button_4);

        mReponse1Button.setOnClickListener(this);
        mReponse2Button.setOnClickListener(this);
        mReponse3Button.setOnClickListener(this);
        mReponse4Button.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getCurrentQuestion();
        displayQuestion(mCurrentQuestion);

        mRemainingQuestionCount = 4;
        mScore = 0;
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
        mQuestionTextView.setText(question.getQuestion());
        List<String> answers = question.getChoiceList();
        mReponse1Button.setText(answers.get(0));
        mReponse2Button.setText(answers.get(1));
        mReponse3Button.setText(answers.get(2));
        mReponse4Button.setText(answers.get(3));
    }

    @Override
    public void onClick(View v) {

        int index;

        if (v == mReponse1Button) {
            index = 0;
        } else if (v == mReponse2Button) {
            index = 1;
        } else if (v == mReponse3Button) {
            index = 2;
        } else if (v == mReponse4Button) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }

        if(index == mQuestionBank.getCurrentQuestion().getAnswerIndex()){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            mScore++;
        }else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        mRemainingQuestionCount--;

        if (mRemainingQuestionCount > 0) {
            mCurrentQuestion = mQuestionBank.getNextQuestion();
            displayQuestion(mCurrentQuestion);
        } else {
            // No question left, end the game
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Well done!")
                    .setMessage("Your score is " + mScore)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .create()
                    .show();
        }


    }

}