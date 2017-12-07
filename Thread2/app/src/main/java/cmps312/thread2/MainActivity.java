package cmps312.thread2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);

        Log.i("ThreadID","Thread id"+Thread.currentThread().getId());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t1=new Thread(new MyThread());
                Thread t2=new Thread(new MyThread());
                t1.start();
                t2.start();

            }
        });
    }

    class MyThread implements Runnable{
       public void run()
       {
           for (int i=1;i<1000;i++)
               Log.i("ThreadID","Thread id="+Thread.currentThread().getId()+","+i++);
       }
   }
}
