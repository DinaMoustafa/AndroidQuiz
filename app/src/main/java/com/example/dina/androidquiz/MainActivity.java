package com.example.dina.androidquiz;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText myEditText;
    Button button;
    //Quiz Total Score
    int quizScore;
    RadioGroup question1;
    RadioGroup question2;
    RadioGroup question3;
    RadioGroup question4;
    RadioButton q1Answer1;
    RadioButton q1Answer2;
    //correct one
    RadioButton q1Answer3;
    //correct one
    RadioButton q2Answer1;
    RadioButton q2Answer2;
    RadioButton q3Answer1;
    //correct one
    RadioButton q3Answer2;
    RadioButton q3Answer3;
    RadioButton q4Answer1;
    //correct one
    RadioButton q4Answer2;
    //correct one
    CheckBox q5Answer1;
    CheckBox q5Answer2;
    //correct one
    CheckBox q5Answer3;
    CheckBox q5Answer4;
    EditText q6Answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myEditText = findViewById(R.id.edit_text);
        q1Answer1 = findViewById(R.id.q1_answer1);
        q1Answer2 = findViewById(R.id.q1_answer2);
        q1Answer3 = findViewById(R.id.q1_answer3);
        q2Answer1 = findViewById(R.id.q2_answer1);
        q2Answer2 = findViewById(R.id.q2_answer2);
        q3Answer1 = findViewById(R.id.q3_answer1);
        q3Answer2 = findViewById(R.id.q3_answer2);
        q3Answer3 = findViewById(R.id.q3_answer3);
        q4Answer1 = findViewById(R.id.q4_answer1);
        q4Answer2 = findViewById(R.id.q4_answer2);
        q5Answer1 = findViewById(R.id.q5_answer1);
        q5Answer2 = findViewById(R.id.q5_answer2);
        q5Answer3 = findViewById(R.id.q5_answer3);
        q5Answer4 = findViewById(R.id.q5_answer4);
        q6Answer = findViewById(R.id.answer_text);
        button = findViewById(R.id.submit_button);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    /**
     * This Button when is clicked appear Total Score
     *
     * @param v
     */
    public void submitButton(View v) {

        String text = myEditText.getText().toString();
        // You must Enter Your Name.
        if (text == null || text.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.name_attention, Toast.LENGTH_SHORT).show();
            return;
        }
        int totalScore = quizScore();
        Toast.makeText(getApplicationContext(), getString(R.string.display_hey) + ", " + text + "\n" + "You get " + totalScore + " out of 6", Toast.LENGTH_SHORT).show();
        button.setEnabled(false);
    }


    public int quizScore() {

        boolean hasQ5Answer1 = q5Answer1.isChecked();
        boolean hasQ5Answer3 = q5Answer3.isChecked();
        String question6Answer = q6Answer.getText().toString().trim().toLowerCase();
        if (q1Answer3.isChecked()) {
            quizScore += 1;
        }
        if (q2Answer1.isChecked()) {
            quizScore += 1;
        }
        if (q3Answer2.isChecked()) {
            quizScore += 1;
        }
        if (q4Answer2.isChecked()) {
            quizScore += 1;
        }
        if (hasQ5Answer1 && hasQ5Answer3) {
            quizScore += 1;
        }
        if (question6Answer.equalsIgnoreCase(getString(com.example.dina.androidquiz.R.string.programming_language))) {
            quizScore += 1;
        } else {
            Toast.makeText(getApplicationContext(), R.string.message, Toast.LENGTH_SHORT).show();
        }
        return quizScore;
    }


    /**
     * This method uncheck all Answers
     *
     * @param view
     */
    public void resetButton(View view) {

        question1 = (RadioGroup) findViewById(R.id.question1);
        question2 = (RadioGroup) findViewById(R.id.question2);
        question3 = (RadioGroup) findViewById(R.id.question3);
        question4 = (RadioGroup) findViewById(R.id.question4);
        quizScore = 0;
        myEditText.setText("");
        question1.clearCheck();
        question2.clearCheck();
        question3.clearCheck();
        question4.clearCheck();
        q5Answer1.setChecked(false);
        q5Answer2.setChecked(false);
        q5Answer3.setChecked(false);
        q5Answer4.setChecked(false);
        q6Answer.setText("");
        Toast.makeText(getApplicationContext(), R.string.trial, Toast.LENGTH_SHORT).show();
        // Enable submit button
        button.setEnabled(true);
    }


    /**
     * You must select only two checkboxes.
     **/
    public void checkBoxManager(View view) {

        int selectedCheckbox = view.getId();
        int countSelected = 0;
        if (q5Answer1.isChecked()) {
            countSelected++;
        }
        if (q5Answer2.isChecked()) {
            countSelected++;
        }
        if (q5Answer3.isChecked()) {
            countSelected++;
        }
        if (q5Answer4.isChecked()) {
            countSelected++;
        }
        if (countSelected > 2) {
            if (q5Answer1.getId() == selectedCheckbox) {
                q5Answer1.setChecked(false);
            } else if (q5Answer2.getId() == selectedCheckbox) {
                q5Answer2.setChecked(false);
            } else if (q5Answer3.getId() == selectedCheckbox) {
                q5Answer3.setChecked(false);
            } else if (q5Answer4.getId() == selectedCheckbox) {
                q5Answer4.setChecked(false);
            }
        }
    }
}


