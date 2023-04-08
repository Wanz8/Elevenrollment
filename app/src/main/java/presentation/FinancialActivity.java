package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.elevenlogin.R;

import java.math.BigDecimal;
import java.util.List;

import persistence.Utils.Student;
import persistence.Utils.hsqldb.AccessStudents;

public class FinancialActivity extends AppCompatActivity {

    String price = "0";
    AccessStudents accessStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial);
        TextView tvTotal = findViewById(R.id.tv_total);
        accessStudents = new AccessStudents();
        List<Student> list = accessStudents.getStudents();
        for (Student bean : list) {
            BigDecimal b1 = new BigDecimal(price);
            BigDecimal b2 = new BigDecimal(bean.getStudentPrice());
            price = b2.add(b1).toString();
        }
        BigDecimal b1 = new BigDecimal("8659.46");
        BigDecimal b2 = new BigDecimal("7506.90");
        BigDecimal b3 = new BigDecimal("" + price);
        String str = b1.subtract(b2).add(b3).toString();
        tvTotal.setText("$" + str);
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
        findViewById(R.id.ll_detail).setOnClickListener(view -> {
            startActivity(new Intent(this, SummaryActivity.class));
        });
        findViewById(R.id.tab2).setOnClickListener(view -> {
            startActivity(new Intent(this, SummaryActivity.class).putExtra("type", 1));
        });
    }
}