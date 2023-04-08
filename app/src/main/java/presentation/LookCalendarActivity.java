package presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elevenlogin.R;

import java.util.ArrayList;
import java.util.List;

import persistence.Utils.Student;
import persistence.Utils.hsqldb.AccessCourses;
import persistence.Utils.hsqldb.AccessStudents;

public class LookCalendarActivity extends AppCompatActivity {
    RecyclerView recycler;
    LookCalendarAdapter cadapter;

    private AccessCourses accessCourses;
    AccessStudents accessStudents;
    List<String> list = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);
        list.add("MWF 8:15 am - 9:15 am \n Buller Building 306");
        list.add("MWF 10:00 am - 11:15 am \n Arms Building 234");
        list.add("MWF 12:15 pm - 1:15 pm \n EITC-100");
        list.add("MWF 2:15 pm - 3:15 pm \n Fletcher Building 100");
        list.add("MWF 4:35 pm - 5:15 pm \n Drake Building 200");
        list.add("TR 8:15 am - 9:15 am \n UC 300");
        list.add("TR 10:00 am - 11:15 am \n Roblim Hall 200");
        list.add("TR 12:15 pm - 1:15 pm \n EITC-200");
        list.add("TR 2:15 pm - 3:15 pm \n Fletcher Building 100");
        list.add("TR 4:35 pm - 5:15 pm \n Drake Building 150");




        accessCourses = new AccessCourses();
        accessStudents = new AccessStudents();
        recycler = findViewById(R.id.recycler);
        cadapter = new LookCalendarAdapter(list);
        recycler.setAdapter(cadapter);
        cadapter.setNewData(accessStudents.getStudents());
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
    }
}