package utv.uzitech.exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class TestActivity extends AppCompatActivity {

    TextView questionField;
    Button optionA, optionB, optionC, optionD;
    int subject, questionNo = 0, score = 0, selectedQuestion;
    String[] questionSet, optionSet;
    int[] answerSet;
    ArrayList<Integer> questionDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questionField = findViewById(R.id.question);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        subject = getIntent().getIntExtra("Subject", 0);

        if (subject == 1) {
            testPhysics();
        } else if (subject == 2) {
            testChemistry();
        } else if (subject == 3) {
            testMaths();
        }
    }

    private void endTest() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Subject", subject);
        intent.putExtra("Score", score);
        startActivity(intent);
        finish();
    }

    private void setQuestion() {
        boolean selected = false;
        while (!selected) {
            selectedQuestion = new Random().nextInt(5);
            if (!questionDone.contains(selectedQuestion)) {
                questionDone.add(selectedQuestion);
                selected = true;
            }
        }

        questionField.setText(questionSet[selectedQuestion]);
        String[] options = optionSet[selectedQuestion].split(";");

        optionA.setText(options[0]);
        optionB.setText(options[1]);
        optionC.setText(options[2]);
        optionD.setText(options[3]);

        optionA.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 0) {
                score += 1;
            }

            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });

        optionB.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 1) {
                score += 1;
            }

            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });

        optionC.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 2) {
                score += 1;
            }

            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });

        optionD.setOnClickListener(v -> {
            questionNo += 1;
            if (answerSet[selectedQuestion] == 3) {
                score += 1;
            }

            if (questionNo == 5) {
                endTest();
            } else {
                setQuestion();
            }
        });
    }

    private void testPhysics() {
        questionSet = new String[]{"A boy starts from a point A, travels to a point B at a distance of 1.5 km and returns to A. If he takes one hour to do so, his average velocity is",
                "The force required to produce an acceleration of 2 m/s² on a mass of 2 kg is",
                "Hookes law essentially defines",
                "A missile is launched with a velocity less than the escape velocity. The sum of its kinetic and potential energy is",
                "Spring is pulled down by 2 cm. What is amplitude of motion?"};

        optionSet = new String[]{"3 Km/h;2 Km/h;0 Km/h;1.5 Km/h",
                "18 N;10 N;22 N;4 N",
                "Elastic Limit;Stress;Strain;Yield Point",
                "Zero;Negative;Positive;Cannot Determine",
                "0 cm;2 cm;4 cm;6 cm"};

        answerSet = new int[]{2, 3, 0, 1, 1};

        questionDone = new ArrayList<>();
        setQuestion();
    }

    private void testChemistry() {
        questionSet = new String[]{"Which of the following element has least number of electrons in its M-shell?",
                "The state of matter that shows the uniformity of behavior is",
                "The temperature of the system decreases in an",
                "Hydrogen has how many isotopes?",
                "A sub-shell with n = 6 , l = 2 can accommodate a maximum of"};

        optionSet = new String[]{"K;Mn;Ni;Sc",
                "Solid;Liquid;Gas;None",
                "Adiabatic Compression;Isothermal Expansion;Isothermal Compression;Adiabatic Expansion",
                "2;3;4;5",
                "12 electrons;36 electrons;10 electrons;72 electrons"};

        answerSet = new int[]{0, 2, 3, 2, 2};

        questionDone = new ArrayList<>();
        setQuestion();
    }

    private void testMaths() {
        questionSet = new String[]{"The value of cos 5π is",
                "If a, b, c are in AP then",
                "Range of the data 4, 7, 8, 9, 10, 12, 13 and 17 is",
                "Two lines are perpendicular if the product of their slopes is",
                "Sum of two rational numbers is"};

        optionSet = new String[]{"0;1;-1;None",
                "b = a + c;2b = a + c;b² = a + c;2b² = a + c",
                "4;13;17;21",
                "-1;0;1;None",
                "Integer;None;Irrational;Rational"};

        answerSet = new int[]{2, 1, 1, 0, 3};

        questionDone = new ArrayList<>();
        setQuestion();
    }
}