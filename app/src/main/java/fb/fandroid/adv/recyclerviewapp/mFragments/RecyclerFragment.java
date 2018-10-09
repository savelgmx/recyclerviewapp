package fb.fandroid.adv.recyclerviewapp.mFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fb.fandroid.adv.recyclerviewapp.R;
import fb.fandroid.adv.recyclerviewapp.mock.MockAdapter;
import fb.fandroid.adv.recyclerviewapp.mock.MockGenerator;

/**
 * Created by Administrator on 08.10.2018.
 */

public class RecyclerFragment extends Fragment{
    private RecyclerView mRecycler;
    private final MockAdapter mMockAdapter=new MockAdapter();


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
         mRecycler = view.findViewById(R.id.recycler);
         }


@Override
    public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    mRecycler.setAdapter(mMockAdapter);
    mMockAdapter.addData(MockGenerator.generate(20));
}


}


