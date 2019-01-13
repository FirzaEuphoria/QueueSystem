package com.hackathon.hackathon;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class OrganizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
         final EditText test = (EditText)findViewById(R.id.test);

         ArrayList<String> tests = new ArrayList<>();
         tests.add("Hello");
         tests.add("arrau");
         tests.add("stack");
         FirebaseDatabase.getInstance().getReference("User1").setValue(1);
         FirebaseDatabase.getInstance().getReference("User2").setValue(2);
         FirebaseDatabase.getInstance().getReference("User3").setValue(3);
         FirebaseDatabase.getInstance().getReference("User4").setValue(tests);
         JobScheduler scheduler = (JobScheduler) this.getSystemService(Context.JOB_SCHEDULER_SERVICE);

         ComponentName service = new ComponentName(this, JobSchedulerService.class);
         JobInfo inf = new JobInfo.Builder(2, service).setMinimumLatency(1000).build();
         scheduler.schedule(inf);



         Timer time =new Timer();
         time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        test.setText(""+Math.random());
                    }
                });
            }
        }, 1000, 1000); // does this task every second





    }






}
