package cmps312.asynctaskexample;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText n;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=(ProgressBar)findViewById(R.id.progressBar);
        pb.setMax(10);
        n=(EditText)findViewById(R.id.editText);
        b1=(Button) findViewById(R.id.button);
        pb.setVisibility(View.INVISIBLE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m=Integer.parseInt(n.getText().toString());
                BackgroundTask b=new BackgroundTask();
                b.execute(m);
            }
        });


    }
    private class BackgroundTask extends AsyncTask<Integer, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
            pb.setProgress(0);
        }
        @Override
        protected String doInBackground(Integer... max) {
            int m=max[0];
            for (int i=1;i<=m;i++)
            {
                SystemClock.sleep(1000);
                int prog=m/10;
                if (i%prog==0)
                    publishProgress(i/prog);
            }
            return "finished";
        }
        @Override
        protected void onProgressUpdate(Integer... values)
        {
            pb.setProgress(values[0]);
        }
        @Override
        protected void onPostExecute(String result)
        {
            pb.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
        }
    }

}
