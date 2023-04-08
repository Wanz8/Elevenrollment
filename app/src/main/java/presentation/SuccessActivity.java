package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.elevenlogin.R;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        int type = getIntent().getIntExtra("type", 0);
        TextView tv = findViewById(R.id.tv);
        tv.setText(type == 1 ? "Payment Successful" : "Submitted!!");
        findViewById(R.id.ivBack).setOnClickListener(v -> {
            finish();
        });
    }
}