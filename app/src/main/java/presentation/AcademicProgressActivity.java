package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.elevenlogin.R;

public class AcademicProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_progress);
        findViewById(R.id.tab1).setOnClickListener(v -> {
            startActivity(new Intent(this,CreditHourActivity.class));
        });
        findViewById(R.id.tab2).setOnClickListener(v -> {
            startActivity(new Intent(this,GRADEActivity.class));
        });
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
    }
}