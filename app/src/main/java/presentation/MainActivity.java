package presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elevenlogin.R;

import business.SharedPreferencesHelper;
import business.UserInfo;

public class MainActivity extends AppCompatActivity {



    // Account
    EditText userId,pwd;

    TextView temp;

    Button signIn, signUp;

    // Result

    String loginName;

    // Typein pwd
    String loginPwd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userId = findViewById(R.id.userId);
        pwd = findViewById(R.id.pwd);

        signIn = findViewById(R.id.signIn);
        signUp = findViewById(R.id.signUp);

        //temp = findViewById(R.id.temp);



        UserInfo userInfo = new UserInfo();
        loginName = userInfo.getAccountNewName();
        loginPwd = userInfo.getAccountNewPwd();


        // Listener
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get user's login acc and pwd
                String username = userId.getText().toString().toString();
                String password = pwd.getText().toString();

                SharedPreferencesHelper preferencesHelper=new SharedPreferencesHelper();
                 String  Info =(String) preferencesHelper.get("zh"+username,"");
                if (TextUtils.isEmpty(Info)){
                    Toast.makeText(MainActivity.this,"Account not exist, Please sign up first",Toast.LENGTH_SHORT).show();
                }else {
                    String  pass =(String) preferencesHelper.get("pas"+username,"");
                    String  nick =(String) preferencesHelper.get("nick"+username,"");
                    Log.e("ddds", "onClick: "+nick);
                    if (!TextUtils.equals(password,pass)){
                        Toast.makeText(MainActivity.this,"Incorrect Password",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent welcomeIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(welcomeIntent);
                    }
                }

                //debug
             /*   temp.setText(username);



                if(username=="" || password==""){
                    Toast.makeText(MainActivity.this,"Username or password cannot be empty!!!",Toast.LENGTH_LONG).show();
                }else {


                    if (loginName == null) {
                        Toast.makeText(MainActivity.this, "You haven't registered yet!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (loginName.equals(username) == true && loginPwd.equals(password) == true) {
                            // If success, jump

                        } else {
                            // Acc or pwd incorrect
                            Toast.makeText(MainActivity.this, "Incorrect Password or userName", Toast.LENGTH_SHORT).show();
                        }
                    }
                }*/
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                MainActivity.this.startActivity(signUpIntent);
            }
        });
    }



}