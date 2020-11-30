package utv.uzitech.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, TestActivity.class);
    }

    public void openPhysics(View view) {
        intent.putExtra("Subject", 1);
        startActivity(intent);
        finish();
    }

    public void openChemistry(View view) {
        intent.putExtra("Subject", 2);
        startActivity(intent);
        finish();
    }

    public void openMaths(View view) {
        intent.putExtra("Subject", 3);
        startActivity(intent);
        finish();
    }
}