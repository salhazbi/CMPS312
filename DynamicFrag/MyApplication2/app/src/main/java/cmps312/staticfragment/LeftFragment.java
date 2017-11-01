package cmps312.staticfragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cmps312.staticfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

ListView myList;
    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_left, container, false);
        myList=(ListView)v.findViewById(R.id.List1);
        String c[]={"CMPS151","CMPS251","CMPS303","CMPS312"};
        myList.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,c));
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final RightFragment f=(RightFragment)getFragmentManager().findFragmentById(R.id.f2);
                f.change(i);

            }
        });
        return v;
    }

}
