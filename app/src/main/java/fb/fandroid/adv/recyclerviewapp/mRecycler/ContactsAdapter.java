package fb.fandroid.adv.recyclerviewapp.mRecycler;


import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fb.fandroid.adv.recyclerviewapp.R;
import fb.fandroid.adv.recyclerviewapp.mock.Mock;
import fb.fandroid.adv.recyclerviewapp.mock.MockAdapter;
import fb.fandroid.adv.recyclerviewapp.mock.MockHolder;



public class ContactsAdapter extends RecyclerView.Adapter<MockHolder>{
    private final List<Mock> mMockList= new ArrayList<>();
    private Cursor mCursor;

    @NonNull
    @Override
    public MockHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());// Теперь у нас есть Inflater.
        View view = inflater.inflate(R.layout.li_mock, parent, false); //Inflater
        // нужен для того, чтобы из xml-разметки сделать view.
        return new MockHolder(view); // возвращаем наш ViewHolder,// которому передаем на вход созданную view.

    }

    @Override
    public void onBindViewHolder(@NonNull MockHolder holder, int position) {
       // holder.bind(mMockList.get(position));

// Теперь нам нужно обработать onBindViewHolder(), то есть нам нужно получить
//        данные из кусора и скормить его холдеру, чтоб он уже их показал. Пишем:
        if(mCursor.moveToPosition(position)){
            String name = mCursor.getString(mCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            int id = mCursor.getInt(mCursor.getColumnIndex(ContactsContract.Contacts._ID));

            holder.bind(new Mock(name,id)); //создать объект Mock и передать в метод bind его – по старой логике.

             }

    }

    @Override
    public int getItemCount() {
        return mCursor !=null? mCursor.getCount():0;
    }


    public void swapCursor(Cursor cursor) {
        if (cursor != null && cursor != mCursor) {
            if (mCursor != null) mCursor.close();
            mCursor = cursor;
            notifyDataSetChanged();
        }
    }

    public interface OnItemClickListener{

        void OnItemClick();
    }

}
