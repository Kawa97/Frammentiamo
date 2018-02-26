package com.example.corsista.frammentiamo.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.corsista.frammentiamo.R;

/**
 * Created by corsista on 22/02/2018.
 */

public class DetailFragment extends Fragment {
    private String text;
    String[] DETTAGLI = new String[] { "AAAAAAAAAAAAAAAAAAA", "BBBBBBBBBBBBB", "CCCCCCCCCC"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.detail_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView textView= (TextView) view.findViewById(R.id.detailView);
        textView.setText(DETTAGLI[getArguments().getInt("posizione")]);
    }

}
