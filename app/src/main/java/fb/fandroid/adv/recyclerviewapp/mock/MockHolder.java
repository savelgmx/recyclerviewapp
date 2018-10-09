package fb.fandroid.adv.recyclerviewapp.mock;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fb.fandroid.adv.recyclerviewapp.R;
import fb.fandroid.adv.recyclerviewapp.mRecycler.ContactsAdapter;

/**
 * Created by Administrator on 09.10.2018.
 */

public class MockHolder extends RecyclerView.ViewHolder {


    private TextView mName;
    private TextView mValue;
    private String mId;

    public MockHolder(View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_name);
        mValue = itemView.findViewById(R.id.tv_value);
    }

    public void bind(Mock mock) {
        mName.setText(mock.getName());
        mValue.setText(mock.getValue());
        mId = mock.getValue();
    }

    public void setListener(final ContactsAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(mId);
            }
        });
    }
}
