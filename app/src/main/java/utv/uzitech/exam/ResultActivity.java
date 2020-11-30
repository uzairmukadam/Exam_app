package utv.uzitech.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView title, score;
    int subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        title = findViewById(R.id.title);
        score = findViewById(R.id.score);

        subject = getIntent().getIntExtra("Subject", 0);

        if (subject == 1) {
            title.setText("In Physic, you scored");
        } else if (subject == 2) {
            title.setText("In Chemistry, you scored");
        } else if (subject == 3) {
            title.setText("In Maths, you scored");
        }

        int scoreAchieved = getIntent().getIntExtra("Score", 0);

        score.setText(String.valueOf(scoreAchieved) + "/5");
    }

    public void retry(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra("Subject", subject);
        startActivity(intent);
        finish();
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}