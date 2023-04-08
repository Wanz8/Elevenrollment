package presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.elevenlogin.R;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.GRADEBean;

public class GRADEActivity extends AppCompatActivity {
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        recycler=findViewById(R.id.recycler);
        GRADEAdapter madapter=new GRADEAdapter();
        recycler.setAdapter(madapter);
        List<GRADEBean> list=new ArrayList<>();
        list.add(new GRADEBean("Fall2020","Families in Canada","FMLY1000","A"));
        list.add(new GRADEBean("Fall2020","Statistic and Computing","STAT2150","B"));
        list.add(new GRADEBean("Fall2020","Life in Universe","ASTR1830","B+"));
        list.add(new GRADEBean("Winter2021","Multivariable Calculus","MATH2720","A"));
        list.add(new GRADEBean("Winter2021","Elementary Discrete","MATH1240","C"));
        list.add(new GRADEBean("Winter2021","Basic Statistical","STAT2000","B"));
        list.add(new GRADEBean("Summer2021","Financial Accounting","ACC1100","A"));
        list.add(new GRADEBean("Summer2021","Human Resources","HRIR2440","B"));
        list.add(new GRADEBean("Fall2021","Supply Chain","SCM2160","C"));
        list.add(new GRADEBean("Fall2021","Nutrition","HNSC1200","B+"));
        madapter.setNewData(list);

        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
    }
}