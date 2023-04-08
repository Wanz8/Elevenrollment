package presentation;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elevenlogin.R;

public class FAQActivity extends AppCompatActivity {
    TextView tvTitle, content;
   public static FAQActivity transcriptActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        String title = getIntent().getStringExtra("title");
        String cont = getIntent().getStringExtra("cont");
        tvTitle = findViewById(R.id.tvTitle);
        content = findViewById(R.id.content);
        tvTitle.setText(title);
        content.setText(Html.fromHtml(cont));
        findViewById(R.id.ivBack).setOnClickListener(v -> {
            finish();
        });
    }
}