package presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elevenlogin.R;

import persistence.Utils.Student;
import persistence.Utils.hsqldb.AccessCourses;
import persistence.Utils.hsqldb.AccessStudents;

public class AddCourseActivity extends AppCompatActivity {
    RecyclerView recycler;
    CourseAdapter cadapter;
      AccessCourses accessCourses;
    AccessStudents accessStudents;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);
        accessCourses = new AccessCourses();
        accessStudents = new AccessStudents();
        recycler = findViewById(R.id.recycler);
        cadapter = new CourseAdapter();
        recycler.setAdapter(cadapter);
        cadapter.setNewData(accessCourses.getCourses());
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
        cadapter.setOnItemClickListener((adapter, view, position) -> {
            accessStudents.insertStudent(new Student("2" + position + "",
                    cadapter.getItem(position).getCourseID(), cadapter.getItem(position).getCourseName(), cadapter.getItem(position).getCoursePrice()));
            finish();
        });
    }
}