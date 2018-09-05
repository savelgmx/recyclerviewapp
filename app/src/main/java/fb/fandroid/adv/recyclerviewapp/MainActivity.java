package fb.fandroid.adv.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
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

    Menu menu;

    ArrayList<Contact> contacts;

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

                //-Add Element type1  in Recycler view

                //----end of launch transaction+-


                return true;
            case R.id.action_add_type2_item:
             case R.id.action_exit:
                // showMessage("Вы выбрали Выход");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_users);
        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(contacts);

        rvContacts.setAdapter(adapter);// Attach the adapter to the recyclerview to populate items
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}
