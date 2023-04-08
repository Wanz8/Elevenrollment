package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.elevenlogin.R;

public class ImgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        findViewById(R.id.ivBack).setOnClickListener(v -> {
            finish();
        });
    }
}