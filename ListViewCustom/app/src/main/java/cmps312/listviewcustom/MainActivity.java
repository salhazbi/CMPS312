package cmps312.listviewcustom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Course c[]={new Course("CMS151","Programming"),
                new Course("CMS251","OOP"),
                new Course("CMS303","DS"),
                new Course("CMS312","Mobile programming"),
        };

        list=(ListView)findViewById(R.id.list1);
        list.setAdapter(new CourseAdapter(this,c));

    }
    class CourseAdapter extends ArrayAdapter<Course>
    {
       public CourseAdapter(Context c, Course cr[])
       {
           super( c,R.layout.single_row,cr);
       }
       public View getView (int p, View v, ViewGroup parent)
       {
           if (v==null)
           {
               LayoutInflater in=LayoutInflater.from(getContext());
               v=in.inflate(R.layout.single_row,parent,false);

           }
           TextView cid=v.findViewById(R.id.t1);
           TextView cn=v.findViewById(R.id.t2);
           cid.setText(getItem(p).getId());
           cn.setText(getItem(p).getName());
           return v;
       }
    }
}
