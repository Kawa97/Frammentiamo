package com.example.corsista.frammentiamo.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corsista.frammentiamo.OnHeadlineSelectedListener;
import com.example.corsista.frammentiamo.R;
import com.example.corsista.frammentiamo.ui.adapter.CustomArrayAdapter;

/**
 * Created by corsista on 22/02/2018.
 */

public class ListFragment extends Fragment {
    OnHeadlineSelectedListener mCallback;
    CustomArrayAdapter adapter;
    static final String[] SEZIONI = new String[] { "Sezione 1", "Sezione 2", "Sezione 3"};

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View view  = inflater.inflate(R.layout.list_fragment,container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        adapter = new CustomArrayAdapter(getActivity(),SEZIONI);
        final ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String sezione[]=adapter.getValues();
                Toast.makeText(getActivity(), sezione[position], Toast.LENGTH_SHORT).show();
                mCallback.onArticleSelected(position);
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
