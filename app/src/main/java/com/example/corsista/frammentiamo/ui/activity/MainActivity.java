package com.example.corsista.frammentiamo.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
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

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            ListFragment listFragment = new ListFragment();
            fragmentTransaction.replace(R.id.contenitoreFragment,listFragment);
            fragmentTransaction.commit();
            DetailFragment detailFragment= new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("posizione",0);
            detailFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.contenitoreDetail,detailFragment);
        }
        else {
            ListFragment listFragment = new ListFragment();
            fragmentTransaction.add(R.id.contenitoreFragment,listFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onArticleSelected(int position) {
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            FragmentManager fragmentManager=getFragmentManager();
            FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putInt("posizione",position);
            DetailFragment detailFragment= new DetailFragment();
            detailFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.contenitoreDetail,detailFragment);
            fragmentTransaction.commit();
        }
        else{
        selectedDetail=DETTAGLI[position];
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt("posizione",position);
        DetailFragment detailFragment= new DetailFragment();
        detailFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.contenitoreFragment,detailFragment).commit();
        }
    }
}
