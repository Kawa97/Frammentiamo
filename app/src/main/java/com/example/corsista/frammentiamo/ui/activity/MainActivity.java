package com.example.corsista.frammentiamo.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.corsista.frammentiamo.OnHeadlineSelectedListener;
import com.example.corsista.frammentiamo.R;
import com.example.corsista.frammentiamo.data.Detail;
import com.example.corsista.frammentiamo.ui.fragment.DetailFragment;
import com.example.corsista.frammentiamo.ui.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnHeadlineSelectedListener{
    String[] DETTAGLI = new String[] { "AAAAAAAAAAAAAAAAAAA", "BBBBBBBBBBBBB", "CCCCCCCCCC"};
    String selectedDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

        ListFragment listFragment = new ListFragment();
        fragmentTransaction.add(R.id.contenitoreFragment,listFragment);
        DetailFragment detailFragment= new DetailFragment();
        detailFragment.setArguments(selectedDetail);
        fragmentTransaction.add(R.id.contenitoreFragment,detailFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onArticleSelected(int position) {
        selectedDetail=DETTAGLI[position];
    }
}
