package cmps312.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView t1;
    private Button b1;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView);
        b1=(Button)findViewById(R.id.button);
        SharedPreferences p=getSharedPreferences("myData",MODE_PRIVATE);
        count=p.getInt("countValue",0);
        t1.setText(count+"");
    }
    public void update(View v)
    {
        count++;
        t1.setText(count+"");
    }
    public void onStop()
    {
        super.onStop();
        SharedPreferences p=getSharedPreferences("myData",MODE_PRIVATE);
        SharedPreferences.Editor e=p.edit();
        e.putInt("countValue",count);
        e.commit();
    }
}
