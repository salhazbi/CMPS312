package cmps312.handlersimpleexample;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText n;
    ProgressBar pb;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=(ProgressBar)findViewById(R.id.progressBar);
        pb.setMax(10);
        n=(EditText)findViewById(R.id.editText);
        b1=(Button) findViewById(R.id.button);
        pb.setVisibility(View.INVISIBLE);
       h=new Handler(){
         public void handleMessage(Message msg)
         {

             pb.setProgress(msg.arg1);
         }
       };
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                int m=Integer.parseInt(n.getText().toString());
                Thread th=new Thread(new MyThread(m));
                th.start();
            }
        });

    }
    class MyThread implements Runnable{
        int max;
        public MyThread(int m)
        {
            max=m;
        }
        @Override
        public void run() {

            for (int i=1;i<=max;i++)
            {
                SystemClock.sleep(1000);
                int prog=max/10;
                if (i%prog==0) {
                    Message msg= Message.obtain();
                    msg.arg1=i/prog;
                    h.sendMessage(msg);
                }

            }
        }
    }
}
