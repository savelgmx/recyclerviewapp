    package fb.fandroid.adv.recyclerviewapp;

    import android.os.Parcelable;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;

    import java.util.ArrayList;

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

        private static final String SAVED_RECYCLER_VIEW_STATUS_ID ="saved_recycler_view_status" ;
        private static final String SAVED_RECYCLER_VIEW_DATASET_ID = "saved_recycler_view_dataset";
        private ArrayList<Parcelable> mDataset;
        private Parcelable mListState;

        ArrayList<Contact> contacts;
        public RecyclerView rvContacts;



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

                    //-Add Element type1  in Recycler view

                    // Add a new contact
                    contacts.add(0, new Contact("Barney", true));
    // Notify the adapter that an item was inserted at position 0
                    rvContacts.getAdapter().notifyDataSetChanged();
                     return true;
                case R.id.action_add_type2_item:
                    //----Add Element type2 in RecyclerView
    // Add a new contact
                    contacts.add(0, new Contact("Type2", true));
                    rvContacts.getAdapter().notifyDataSetChanged();
                    return true;
    // Notify the adapter that an item was inserted at position 0
                    //---end of laucnch add
                case R.id.action_exit:
                    System.exit(0);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_users);// Lookup the recyclerview in activity layout
            rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

            //http://qaru.site/questions/144487/recyclerview-store-restore-state-between-activities
            //---проверим перезапускалось ли приложение( при перевороте экрана например)
            if (savedInstanceState!=null){
                Log.d("savedInstanceState", String.valueOf(savedInstanceState));
                restorePreviousState(); // Восстанавливаем данные найденные в Bundle
            }



            contacts = Contact.createContactsList(2);// Инициализтруем наш список контактов Список элементов первого вида

            ContactsAdapter adapter = new ContactsAdapter(contacts);// Create adapter passing in the sample user data

            rvContacts.setAdapter(adapter);// Attach the adapter to the recyclerview to populate items
            // Set layout manager to position the items
            rvContacts.setLayoutManager(new LinearLayoutManager(this));
            // That's all!
        }

        //------далее идет код для сохраниения состояния просмотра ресайклеров в методе onSaveInstanceState
        @Override
        protected void onSaveInstanceState(Bundle outState) {
            Parcelable listState = rvContacts.getLayoutManager().onSaveInstanceState();
            outState.putParcelable(SAVED_RECYCLER_VIEW_STATUS_ID, listState);// putting recyclerview position

            Log.d("savedInstanceState list", String.valueOf(listState));

            mDataset =outState.getParcelableArrayList(SAVED_RECYCLER_VIEW_DATASET_ID);

            outState.putParcelableArrayList(SAVED_RECYCLER_VIEW_DATASET_ID,mDataset); // putting recyclerview items
            super.onSaveInstanceState(outState);
            Log.d("savedInstanceState data", String.valueOf(mDataset));
        }

        //Восстановить данные просмотра ресайклеров, если экран был повернут

        public void restorePreviousState(){

            Log.d("savedInstanceState res", String.valueOf(mListState));

          //  mListState = mSavedInstanceState.getParcelable(SAVED_RECYCLER_VIEW_STATUS_ID);// getting recyclerview position
            // getting recyclerview items
          //  mDataset = mSavedInstanceState.getParcelableArrayList(SAVED_RECYCLER_VIEW_DATASET_ID);

        //    mAdapter.setItems(mDataset);// Restoring adapter items
            // Restoring recycler view position
         //   mRvMedia.getLayoutManager().onRestoreInstanceState(mListState);
        }
    }
