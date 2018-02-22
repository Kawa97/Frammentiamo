package com.example.corsista.frammentiamo.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corsista.frammentiamo.OnHeadlineSelectedListener;
import com.example.corsista.frammentiamo.R;
import com.example.corsista.frammentiamo.data.Detail;
import com.example.corsista.frammentiamo.ui.adapter.CustomArrayAdapter;

/**
 * Created by corsista on 22/02/2018.
 */

public class DetailFragment extends Fragment {
    OnHeadlineSelectedListener mCallback;
    static String dettaglio;
    private String text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.detail_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView textView= (TextView) view.findViewById(R.id.detailView);
        textView.setText(text);
    }

    public void setArguments(String text) {
        this.text=text;
    }

}
