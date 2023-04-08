package presentation;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elevenlogin.R;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.Result;
import business.SharedPreferencesHelper;

public class SignUpActivity extends AppCompatActivity {

    // Initialize
   Button register;


    EditText password, confirmPassword, nickname, account,description;

    int role;

    // Role
    RadioButton rb_stuff;

    String resultRole="stuff";
    String resultFaculty;

    // Role: student
    RadioButton rb_student;
    CheckBox rb_Arts,rb_Science,rb_Asper,rb_Law;

    String resultDescription;

    RadioGroup rg_gender;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Account
        register = findViewById(R.id.btn_register);
        rg_gender = findViewById(R.id.rg_gender);
        account = findViewById(R.id.edt_account);
        password = findViewById(R.id.edt_password);
        confirmPassword = findViewById(R.id.edt_confirmPassword);
        nickname = findViewById(R.id.edt_username);
        //Role
        rb_stuff = findViewById(R.id.rb_stuff);
        rb_student = findViewById(R.id.rb_student);
        //Faaculty
        rb_Arts = findViewById(R.id.fb_Arts);
        rb_Science = findViewById(R.id.fb_Science);
        rb_Asper = findViewById(R.id.fb_Asper);
        rb_Law = findViewById(R.id.fb_Law);
        //Description
        description = findViewById(R.id.edt_presentation);
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton butt=findViewById(i);
               resultRole=butt.getText().toString();
            }
        });

//        rb_student.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                role = 1;
//            }
//        });
//
//        if (role == 1){
//            resultRole = "Student";
//        }else {
//            resultRole = "Stuff";
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        if(rb_Arts.isChecked()){
//            stringBuilder.append("Arts,");
//        }
//        if(rb_Science.isChecked()){
//            stringBuilder.append("Science,");
//        }
//        if(rb_Asper.isChecked()){
//            stringBuilder.append("Asper,");
//        }
//        if(rb_Law.isChecked()){
//            stringBuilder.append("Law");
//        }
//
//        //Get the last string character
//        String str = stringBuilder.charAt(stringBuilder.length() - 1) + "";
//
//        // If the last string character is ",", cut it off
//        if (str.equals("、")){
//            resultFaculty = stringBuilder.substring(0,stringBuilder.length() - 1);
//        }else {
//            resultFaculty = stringBuilder.toString();
//        }

        //
       // resultDescription = description.getText().toString();



        // listen
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CheckBox rb_Arts,rb_Science,rb_Asper,rb_Law;
                String Fac=rb_Arts.isChecked()?"Arts":rb_Science.isChecked()?"Science":rb_Asper.isChecked()?"Law":rb_Law.isChecked()?"Asper":"";
                List<String> list=new ArrayList<>();
                list.add("Arts");
                list.add("Science");
                list.add("Law");
                String accounts=account.getText().toString().trim();
                String passwords=password.getText().toString().trim();
                String nicknames=nickname.getText().toString().trim();
                String descriptions=description.getText().toString().trim();
                String confirmPasswords=confirmPassword.getText().toString().trim();

                if (!TextUtils.equals(passwords,confirmPasswords)){
                    Toast.makeText(SignUpActivity.this,"密码不一致",Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferencesHelper preferencesHelper=new SharedPreferencesHelper();
                preferencesHelper.put("acc",accounts);
                preferencesHelper.put("zh"+accounts,accounts);
                preferencesHelper.put("pas"+accounts,passwords);
                preferencesHelper.put("nick"+accounts,nicknames);
                preferencesHelper.put("role"+accounts,resultRole);
                preferencesHelper.put("Fac"+accounts,list.toString());
                preferencesHelper.put("dse"+accounts,descriptions);
                Intent resultIntent = new Intent(SignUpActivity.this, Result.class);
                resultIntent.putExtra("accounts",accounts);
                SignUpActivity.this.startActivity(resultIntent);
            }
        });

    }


}
