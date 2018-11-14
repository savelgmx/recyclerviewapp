package fb.fandroid.adv.recyclerviewapp.mFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fb.fandroid.adv.recyclerviewapp.R;
import fb.fandroid.adv.recyclerviewapp.User;
import fb.fandroid.adv.recyclerviewapp.mRecycler.RecyclerViewAdapter;


/**
 * Created by Administrator on 08.10.2018.
 */

public class RecyclerFragment extends Fragment{
    private RecyclerView mRecycler;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       /*Добавляем метод, который берёт данные из ресурсов меню
       и преобразует их в пункты меню на экране.
       По английски "inflate" переводится как надувать,
       т.е. по замыслу разработчиков Android, мы как бы надуваем данными объект, например, меню.
       Но на самом деле слово "inflate" происходит от словосочетания in flat - в квартиру.
       Существует старинная традиция запускать в квартиру первым кота,
       который исследует все закоулки дома и заявляет о своём согласии жить в нём.
       Так и мы запускаем данные из XML-файла в объект MenuInflater.
        */
        inflater.inflate(R.menu.menu_main, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_add_type1_item:

               mRecyclerViewAdapter.addItem(this, RecyclerViewAdapter.USER);//-Add Element type1  in Recycler view
                mRecyclerViewAdapter.notifyItemChanged(mRecyclerViewAdapter.getItemCount());
               mRecycler.scrollToPosition(mRecyclerViewAdapter.getItemCount() - 1);
                return true;
            case R.id.action_add_type2_item:

                 mRecyclerViewAdapter.addItem(this, RecyclerViewAdapter.IMAGE);  //----Add Element type2 in RecyclerView
                mRecyclerViewAdapter.notifyItemChanged(mRecyclerViewAdapter.getItemCount());
               mRecycler.scrollToPosition(mRecyclerViewAdapter.getItemCount() - 1);
                return true;
            case R.id.action_exit:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private ArrayList<Object> getInitData() {
        ArrayList<Object> items = new ArrayList<>();
        items.add(new User("Tiryon", "Lannister")); //элемент 1 вида в списке
        items.add("image"); //элемент 2 вида в списке

        return items;
    }



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        setHasOptionsMenu(true);

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
     }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewAdapter =new RecyclerViewAdapter(getInitData()); //инициалаизируем адаптер и заполним его первонячальными данными
        mRecycler.setAdapter(mRecyclerViewAdapter);

    }


}



