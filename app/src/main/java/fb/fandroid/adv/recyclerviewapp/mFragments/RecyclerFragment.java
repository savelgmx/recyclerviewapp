package fb.fandroid.adv.recyclerviewapp.mFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

import fb.fandroid.adv.recyclerviewapp.R;
import fb.fandroid.adv.recyclerviewapp.User;
import fb.fandroid.adv.recyclerviewapp.mRecycler.RecyclerViewAdapter;


/**
 * Created by Administrator on 08.10.2018.
 */

public class RecyclerFragment extends Fragment{

      //private final MockAdapter mMockAdapter=new MockAdapter();
    private RecyclerView mRecycler;
    private View mErrorView;
    private Random mRandom = new Random();
    private RecyclerViewAdapter mRecyclerViewAdapter;


    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }



    private ArrayList<Object> getInitData() {
        ArrayList<Object> items = new ArrayList<>();
        items.add(new User("Tiryon", "Lannister")); //элемент 1 вида в списке
        items.add("image"); //элемент 2 вида в списке
        items.add(new User("Serceya", "Lannister")); //элемент 1 вида в списке
        items.add("image"); //элемент 2 вида в списке
        items.add(new User("Jame", "Lannister")); //элемент 1 вида в списке
        items.add("image"); //элемент 2 вида в списке



        return items;
    }



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mRecycler = view.findViewById(R.id.recycler);
        mErrorView=view.findViewById(R.id.error_view);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewAdapter =new RecyclerViewAdapter(getInitData()); //инициалаизируем адаптер и заполним его первонячальными данными


        mRecycler.setAdapter(mRecyclerViewAdapter);

    }


}



