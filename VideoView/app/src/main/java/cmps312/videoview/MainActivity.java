package cmps312.videoview;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       vid  = (VideoView)findViewById(R.id.videoView);
    }
    public void start(View v)
    {
        vid.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        vid.start();
    }
}
