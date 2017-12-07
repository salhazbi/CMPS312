package cmps312.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button3);
        t1=(TextView)findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      SystemClock.sleep(10000);
                                      t1.setText("updated on UI thread");
                                  }
                              });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(10000);
                          t1.post(new Runnable() {
                              @Override
                              public void run() {
                                  t1.setText("updated on Background thread");
                              }
                          });
                    }
                }).start();
            }
        });
      /*  b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(10000);
                        MainActivity.this.runOnUiThread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        t1.setText("updated on Background thread");
                                    }
                                });

                    }
                }).start();
            }
        });*/
    }
}
