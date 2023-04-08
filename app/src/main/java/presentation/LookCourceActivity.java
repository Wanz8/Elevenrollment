package presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elevenlogin.R;

import persistence.Utils.Student;
import persistence.Utils.hsqldb.AccessCourses;
import persistence.Utils.hsqldb.AccessStudents;

public class LookCourceActivity extends AppCompatActivity {
    RecyclerView recycler;
    LookCourseAdapter cadapter;

    private AccessCourses accessCourses;
    AccessStudents accessStudents;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);

        accessCourses=new AccessCourses();
        accessStudents=new AccessStudents();
        int type = getIntent().getIntExtra("type", 0);
        recycler = findViewById(R.id.recycler);
        cadapter = new LookCourseAdapter();
        recycler.setAdapter(cadapter);
        cadapter.setNewData(accessStudents.getStudents());
        findViewById(R.id.ivBack).setOnClickListener(view -> {
            finish();
        });
        cadapter.setOnItemClickListener((adapter, view, position) -> {
            if (type == 1) {
                accessStudents.deleteStudent(new Student(cadapter.getItem(position).getStudentID(), "Zhihao", cadapter.getItem(position).getStudentAddress(), cadapter.getItem(position).getStudentPrice()));

                finish();
            }

        });
    }
}