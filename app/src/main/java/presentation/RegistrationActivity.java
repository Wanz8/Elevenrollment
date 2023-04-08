package presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elevenlogin.R;

public class RegistrationActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityregistration);
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
        findViewById(R.id.tvAdd).setOnClickListener(view -> {
            startActivity(new Intent(this,AddCourseActivity.class));
        });
        findViewById(R.id.llLook).setOnClickListener(view -> {
            startActivity(new Intent(this,LookCourceActivity.class));
        });
        findViewById(R.id.llDelet).setOnClickListener(view -> {
            startActivity(new Intent(this,LookCourceActivity.class).putExtra("type",1));
        });
    }
}