package fb.fandroid.adv.recyclerviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import fb.fandroid.adv.recyclerviewapp.mFragments.RecyclerFragment;
import fb.fandroid.adv.recyclerviewapp.mRecycler.RecyclerViewAdapter;

////https://www.grokkingandroid.com/first-glance-androids-recyclerview/
//
//https://guides.codepath.com/android/Using-the-RecyclerView#layoutmanagers


/*
RecyclerViewApp
На экране должен быть определен RecyclerView (на активити или фрагменте - на усмотрение исполнителя)
c вертикальным LinearLayoutManager - обычный список.

RecyclerView должен поддерживать работу с элементами 2х разных типов.
То есть для каждого типа используется свой ViewHolder и свой класс объекта.
Пример реализации смотреть тут:
https://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView

ViewHolder’ы должны быть легко различимы на глаз - например, один хранит изображение, другой - текст.
При запуске приложения в RecyclerView должно быть по 1 элементу обоих типов.

В меню Toolbar’а должны быть 2 кнопки (2 любые иконки на усмотрение исполнителя)
При нажатии на них, в RecyclerView (в конец списка) должен добавляться 1 элемент.
Одна кнопка добавляет элемент 1го типа, вторая - 2го типа.

При нажатии на элемент списка он должен удалиться.
Дополнительно: При перевороте экрана, список должен правильно воссоздаться (элементы должны быть в том же количестве, порядке и типа, что и до поворота).
Дополнительно: При добавлении элемента, список должен прокручиваться до него (чтобы новый элемент был виден на экране).
 */
public class MainActivity extends AppCompatActivity {

    private static Bundle mBundleRecyclerViewState;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_add_type1_item:

                mAdapter = new RecyclerViewAdapter(getIemTypeOne("Serseya","Lannister"));

                mAdapter.addItem(this, RecyclerViewAdapter.USER);//-Add Element type1  in Recycler view
                mAdapter.notifyItemChanged(mAdapter.getItemCount()  );

//                mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
                return true;
            case R.id.action_add_type2_item:

                mAdapter = new RecyclerViewAdapter(getIemTypeTwo());
                mAdapter.addItem(this, RecyclerViewAdapter.IMAGE);  //----Add Element type2 in RecyclerView
                mAdapter.notifyDataSetChanged();
                //               mRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
                return true;
            case R.id.action_exit:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Object> getIemTypeOne(String Name,String LastName) {
        ArrayList<Object> item = new ArrayList<>();
        item.add(new User(Name,LastName));
        return item;
    }
    private ArrayList<Object> getIemTypeTwo() {
        ArrayList<Object> item = new ArrayList<>();
        item.add("image");
        return item;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initViews();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RecyclerFragment.newInstance())
                    .commit();
        }


    }

}
