package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.elevenlogin.R;

import java.math.BigDecimal;
import java.util.List;

import persistence.Utils.Student;
import persistence.Utils.hsqldb.AccessCourses;
import persistence.Utils.hsqldb.AccessStudents;
public class SummaryActivity extends AppCompatActivity {
    TextView tvPrice, tvTotal;

    String price = "0";

    AccessCourses accessCourses;
    AccessStudents accessStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        int type = getIntent().getIntExtra("type", 0);
        tvPrice = findViewById(R.id.tv_price);
        tvTotal = findViewById(R.id.tv_total);
        TextView tvSure = findViewById(R.id.tvSure);
        tvSure.setVisibility(type==0? View.GONE:View.VISIBLE);
        if (type == 1) {

            accessCourses = new AccessCourses();
            accessStudents = new AccessStudents();
            List<Student> list = accessStudents.getStudents();

            for (Student bean : list) {
                 BigDecimal b1 = new BigDecimal(price);
                BigDecimal b2 = new BigDecimal(bean.getStudentPrice());
                price = b2.add(b1).toString();
            }
            tvPrice.setText("$" + price + ".00");
            BigDecimal b1 = new BigDecimal("8659.46");
            BigDecimal b2 = new BigDecimal("7506.90");
            BigDecimal b3 = new BigDecimal("" + price);
            String str = b1.subtract(b2).add(b3).toString();
            tvTotal.setText("$" + str);
        }
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
        findViewById(R.id.tvSure).setOnClickListener(view -> {
            finish();
            startActivity(new Intent(this,SuccessActivity.class).putExtra("type",1));
        });
    }
}