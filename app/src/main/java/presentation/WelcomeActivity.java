package presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elevenlogin.R;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    // Initialize
    TextView register;

    String welcomeNickName;

    String welcomeRole;

    // Mr/Mrs
    String appellation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Band
        register = findViewById(R.id.tv_register);
        findViewById(R.id.skipButton).setOnClickListener(view ->
                startActivity(new Intent(this, HomeActivity.class)));
        // Get userinfo
    /*    UserInfo userInfo = new UserInfo();
        welcomeNickName = userInfo.getAccountNewNickname();
        //welcomeRole = Integer.valueOf(userInfo.getAccountNewRole());
        welcomeRole = userInfo.getAccountNewRole();

        // welcome
        if (welcomeRole.equals("Student")){
            appellation = "Student";
        }else {
            appellation = "Stuff";
        }

        // combine
        String text = "Welcome"  +  welcomeNickName + "！";

        // Print
        register.setText(text);*/

    }

    @Override
    public void onClick(View v) {

    }
}
