package cmps312.looper;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b;
    MyThread th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        th=new MyThread();
        th.start();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                th.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Thread",Thread.currentThread().getId()+"");
                    }
                });
            }
        });
    }
    class MyThread extends Thread
    {
        Handler handler;
        public void run()
        {
            Looper.prepare();
            handler=new Handler();
            Looper.loop();
        }
    }
}
