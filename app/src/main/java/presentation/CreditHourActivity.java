package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.elevenlogin.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.Student;
import persistence.Utils.hsqldb.AccessCourses;
import persistence.Utils.hsqldb.AccessStudents;


public class CreditHourActivity extends AppCompatActivity {
    PieChart pieChart;

    private AccessCourses accessCourses;
    AccessStudents accessStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_hour);
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
        TextView txt=findViewById(R.id.txt);
        accessCourses = new AccessCourses();
        accessStudents = new AccessStudents();
        List<Student> datas =accessStudents.getStudents();
         pieChart = findViewById(R.id.piechart);
        pieChart.getDescription().setEnabled(false);// hiding the introduction word
        // Initialize data
        List<PieEntry> list = new ArrayList<>();
        int num = datas.size() * 3;
        int Unfull=90-num;
        list.add(new PieEntry(30, "Completed"));
        list.add(new PieEntry(Unfull, "Unfulfilled"));
        list.add(new PieEntry(num, "InProgress"));
        txt.setText(" Total : 120 CR\n InProgress : "+num+" CR\n Completed  : 30 CR\n Unfulfilled : "+Unfull+" CR");
//120  30  90
        //
        // 定义PieDataSet
        PieDataSet pieDataSet = new PieDataSet(list, "Academic Transcript");


        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#38C571"));//Green
        colors.add(Color.parseColor("#EB766E"));//Red
        colors.add(Color.parseColor("#3A98D6"));//Blue

        // Set the colour
        // Color settings are set on a one-to-one basis, and will be repeated when the number of colors is less than the number of data displayed
        pieDataSet.setColors(colors);

        // Set the position of text content display (can not be set) default in the figure display text
        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        // Define PieData to pass into pieDataSet
        PieData pieData = new PieData(pieDataSet);

        pieData.setDrawValues(true);
        // Set the value followed by the percentage format
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        // Value after using percentages
        pieChart.setUsePercentValues(true);
        // Set the color of the value display (default black)
        pieData.setValueTextColor(Color.BLACK);
        // Set the size of the value display
        pieData.setValueTextSize(17);

        // Set the color of the text (default white)
        pieChart.setEntryLabelColor(Color.BLACK);

        // insert pieData
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}