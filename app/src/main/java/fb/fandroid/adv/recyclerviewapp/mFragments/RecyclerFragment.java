package fb.fandroid.adv.recyclerviewapp.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fb.fandroid.adv.recyclerviewapp.R;

/**
 * Created by Administrator on 08.10.2018.
 */

public class RecyclerFragment extends Fragment{



public static RecyclerFragment newInstance() {
     return new RecyclerFragment();
     }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
 public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         RecyclerView recycler = view.findViewById(R.id.recycler);
         }






}


