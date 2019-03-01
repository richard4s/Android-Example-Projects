package com.example.richard.classproject1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class ProgressTest extends AppCompatActivity {
    int progresstatus;
    int progress;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_test2);
        ProgressBar pb=(ProgressBar)findViewById(R.id.pgbar);

        pb.setMax(100);
        new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<100; i++){
                    progress=doSomeWork();
                    handler.post(new Runnable(){
                        @Override
                        public void run(){
                            pb.setProgress(progress);
                        }
                    });
                    if(progress==99){
                        handler.post(new Runnable(){
                            @Override
                            public void run(){
                                pb.setVisibility(View.INVISIBLE);
                            }
                        });

                    }
                }

            }
        }).start();
    }
    int doSomeWork() {
        if (progresstatus % 10 == 0) {
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                Log.e(ProgressBar.class.getSimpleName(), ex.getMessage());
            }
        }
        progresstatus=progresstatus+1;
        return progresstatus;
    }
}