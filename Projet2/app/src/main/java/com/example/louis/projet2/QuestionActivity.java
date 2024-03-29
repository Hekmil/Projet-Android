package com.example.louis.projet2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity
{
    Question question = new Question();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TextView txtv5 = (TextView)findViewById(R.id.txtv5);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);
        Button btn5 = (Button)findViewById(R.id.btn5);
        Button btn6 = (Button)findViewById(R.id.btn6);

        txtv5.setText(question.getQuestion(question.currentQuestion, 0));
        btn3.setText(question.getQuestion(question.currentQuestion, 1));
        btn4.setText(question.getQuestion(question.currentQuestion, 2));
        btn5.setText(question.getQuestion(question.currentQuestion, 3));
        btn6.setText(question.getQuestion(question.currentQuestion, 4));
    }

    public void Valider(View v)
    {
        Button buttonPressed = (Button) v;
        if(question.checkAnswer(question.currentQuestion, buttonPressed.getText().toString()))
        {
            Toast.makeText(this, "Bonne réponse ! Rendez vous au lieu suivant !", Toast.LENGTH_LONG);
            question.currentQuestion ++;
            startActivity(new Intent(this, MapsActivity.class));
        }
        else
        {
            Toast.makeText(this, "Mauvaise réponse !", Toast.LENGTH_LONG);
        }
    }
}
