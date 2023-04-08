package persistence.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elevenlogin.R;

import business.SharedPreferencesHelper;
import business.UserInfo;

import presentation.MainActivity;


public class Result extends AppCompatActivity {

    // default
    TextView result;

    // Login btn
    Button login;

    // Account
    String accountName;

    // Password
    String accountPwd;

    // Nickname
    String accountNickname;

    // Role
    String accountRole;

    // Faculty
    String resultFaculty;

    // Description
    String accountDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
String username=getIntent().getStringExtra("accounts");
        // Band
        result = findViewById(R.id.tv_result);

        login = findViewById(R.id.btn_login);

        // Userinfo Obj
        UserInfo userInfo = new UserInfo();


        SharedPreferencesHelper preferencesHelper=new SharedPreferencesHelper();
        // Get user info
        accountName = (String) preferencesHelper.get("zh"+username,"");
        accountPwd =(String) preferencesHelper.get("pas"+username,"");
        accountNickname = (String) preferencesHelper.get("nick"+username,"");
        accountRole = (String) preferencesHelper.get("role"+username,"");
        resultFaculty = (String) preferencesHelper.get("Fac"+username,"");
        accountDescription = (String) preferencesHelper.get("dse"+username,"");

        // Show data/info
        result.setText("Account：" + accountName + "\nPassword：" + accountPwd + "\nNickname：" + accountNickname + "\nRole：" + accountRole + "\nFaculty：" + resultFaculty + "\nDescription：" + accountDescription);

        // listen
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainintent = new Intent(Result.this, MainActivity.class);
                Result.this.startActivity(mainintent);
            }
        });
    }
}

