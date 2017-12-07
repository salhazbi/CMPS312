package cmps312.thread1;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        t1=(TextView)findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              MyThread x=new MyThread();
               new Thread(x).start();
            }
        });
    }
public class MyThread implements Runnable{

    @Override
    public void run() {
        SystemClock.sleep(100);

        t1.post()setText("updated in UI thread");
    }
}
}
