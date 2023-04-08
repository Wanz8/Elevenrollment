package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.elevenlogin.R;

import business.SharedPreferencesHelper;

public class ProfileActivity extends AppCompatActivity {
    TextView name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
        findViewById(R.id.tvSure).setOnClickListener(view -> {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });
        name = findViewById(R.id.name);

        SharedPreferencesHelper preferencesHelper = new SharedPreferencesHelper();
        String username = (String) preferencesHelper.get("acc", "");
        String accountName = (String) preferencesHelper.get("zh" + username, "");
        //String accountPwd =(String) preferencesHelper.get("pas"+username,"");
        String accountNickname = (String) preferencesHelper.get("nick" + username, "");
        String accountRole = (String) preferencesHelper.get("role" + username, "");
        String resultFaculty = (String) preferencesHelper.get("Fac" + username, "");
        String accountDescription = (String) preferencesHelper.get("dse" + username, "");

        // Show data/info
        name.setText("Account：" + accountName + "\nNickname：" + accountNickname + "\nRole：" + accountRole + "\nFaculty：" + resultFaculty + "\nDescription：" + accountDescription);

    }
}