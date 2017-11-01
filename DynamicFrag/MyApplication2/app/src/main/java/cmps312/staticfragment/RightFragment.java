package cmps312.staticfragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cmps312.staticfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RightFragment extends Fragment {
TextView t1,t2,t3;

    public RightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_right, container, false);
        t1=(TextView)v.findViewById(R.id.cid);
        t2=(TextView)v.findViewById(R.id.cName);
        t3=(TextView)v.findViewById(R.id.cPre);
        return v;
    }
    public void change (int i)
    {
        switch (i)
        {
            case 0: t1.setText("CMPS151");
                    t2.setText("Cmps251");
                    t3.setText("");
                    break;
            case 1: t1.setText("CMPS251");
                t2.setText("Cmps251");
                t3.setText("cmps151");
                break;
            case 2: t1.setText("CMPS303");
            t2.setText("Cmps251");
            t3.setText("");
            break;
            case 3: t1.setText("CMPS151");
                t2.setText("hello");
                t3.setText("");
                break;


        }
    }

}
