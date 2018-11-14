package fb.fandroid.adv.recyclerviewapp.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fb.fandroid.adv.recyclerviewapp.R;

public class ViewHolderTypeOne extends RecyclerView.ViewHolder {

    private TextView mFirstName, mSecondName;

    public ViewHolderTypeOne(View v) {
        super(v);
        mFirstName = v.findViewById(R.id.first_name);
        mSecondName = v.findViewById(R.id.second_name);
    }

    public TextView getFirstName() {
        return mFirstName;
    }

    public void setFirstName(TextView firstName) {
        this.mFirstName = firstName;
    }

    public TextView getSecondName() {
        return mSecondName;
    }

    public void setSecondName(TextView secondName) {
        this.mSecondName = secondName;
    }
}
