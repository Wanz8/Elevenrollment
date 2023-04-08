package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.elevenlogin.R;

import persistence.AppUtils;

public class DegreeAwardedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canadian_tax_form);
        findViewById(R.id.ivBack).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.tb2).setOnClickListener(v -> {
            startActivity(new Intent(this, AcademicTranscriptActivity.class)
                    .putExtra("title","Apply for Student Aid")
                    .putExtra("cont", AppUtils.ASA));
        });
        findViewById(R.id.tab1).setOnClickListener(v -> {
            startActivity(new Intent(this, ImgActivity.class));
        });
    }
}