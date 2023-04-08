package presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import com.example.elevenlogin.R;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import persistence.AppUtils;
import persistence.Utils.Main;

public class HomeActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        copyDatabaseToDevice();
        findViewById(R.id.ivSet).setOnClickListener(view -> {

           // Student student=  hsqldb.insertStudent(new Student("111"+n,"哈哈","顶顶顶顶"));
          startActivity(new Intent(this,ProfileActivity.class));
        });
        findViewById(R.id.eforms).setOnClickListener(view -> {
           startActivity(new Intent(this,EformsActivity.class));
        });
        findViewById(R.id.Academic).setOnClickListener(view -> {
            startActivity(new Intent(this, AcademicProgressActivity.class));
        });
        findViewById(R.id.Register).setOnClickListener(view -> {

         //   List<ObjectCourse> lists= hsqldb.getCourseSequential();
        //    Log.e("Retry", "Course: "+lists.toString() );
            startActivity(new Intent(this, RegistrationActivity.class));
        });
        findViewById(R.id.Finances).setOnClickListener(view -> {
            startActivity(new Intent(this,FinancialActivity.class));
        });
        findViewById(R.id.calendar).setOnClickListener(view -> {
            startActivity(new Intent(this,LookCalendarActivity.class));
        });

        findViewById(R.id.faq).setOnClickListener(v -> {
            startActivity(new Intent(this, AcademicTranscriptActivity.class)
                    .putExtra("title","FAQ")
                    .putExtra("cont", AppUtils.FAQ));
        });
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }
}