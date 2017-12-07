package cmps312.networking1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
Button b;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DownloadTask dt=new DownloadTask();
                dt.execute("http://www.qu.edu.qa/static_file/qu/homepage%20components/show%20area/images/qu-ranked-7th-among-the-top-100-universities-in-the-mena-and-asia-regions.jpg");

            }
        });
    }
    public class DownloadTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... param) {
            String imageUrl=param[0];

            try{
                URL url=new URL(imageUrl);
                HttpURLConnection hc=(HttpURLConnection)url.openConnection();
                hc.setRequestMethod("GET");
                hc.connect();
                int response=hc.getResponseCode();
                if (response==HttpURLConnection.HTTP_OK)
                {
                    InputStream in= hc.getInputStream();
                    Bitmap b= BitmapFactory.decodeStream(in);
                    return b;
                }
                else
                    Log.i("connn","not Connected");
            }
            catch(Exception e)
            {
                Log.i("connn",e.toString());
            }
            return null;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            im=(ImageView)findViewById(R.id.imageView);
            im.setImageBitmap(bitmap);
        }



    }

}
