package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.elevenlogin.R;

public class AcademicTranscriptActivity extends AppCompatActivity {
    TextView tvTitle, content;
   public static AcademicTranscriptActivity transcriptActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_transcript);
        String title = getIntent().getStringExtra("title");
        String cont = getIntent().getStringExtra("cont");
        tvTitle = findViewById(R.id.tvTitle);
        content = findViewById(R.id.content);
        tvTitle.setText(title);
        content.setText(Html.fromHtml(cont));
        findViewById(R.id.ivBack).setOnClickListener(v -> {
            finish();
        });
        findViewById(R.id.tvSure).setOnClickListener(v -> {
            finish();
            startActivity(new Intent(this, SuccessActivity.class));

        });
    }
}