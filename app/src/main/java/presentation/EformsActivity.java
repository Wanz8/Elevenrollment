package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.elevenlogin.R;

import persistence.AppUtils;

public class EformsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eforms);
        findViewById(R.id.tab1).setOnClickListener(v -> {
            startActivity(new Intent(this, AcademicTranscriptActivity.class)
                    .putExtra("title","Canadian Tax Form")
                    .putExtra("cont", AppUtils.Document));
        });
        findViewById(R.id.tab2).setOnClickListener(v -> {
            startActivity(new Intent(this, AcademicTranscriptActivity.class)
            .putExtra("title","Academic Transcript")
            .putExtra("cont",AppUtils.AT));
        });
        findViewById(R.id.tab3).setOnClickListener(v -> {
            startActivity(new Intent(this, AcademicTranscriptActivity.class)
                    .putExtra("title","Enrollement Verification")
                    .putExtra("cont",AppUtils.EV));
        });
        findViewById(R.id.tab4).setOnClickListener(v -> {
            startActivity(new Intent(this, DegreeAwardedActivity.class) );
        });
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
    }
}