package fb.fandroid.adv.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
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
