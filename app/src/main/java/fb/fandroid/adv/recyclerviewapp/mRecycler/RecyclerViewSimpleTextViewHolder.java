package fb.fandroid.adv.recyclerviewapp.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class RecyclerViewSimpleTextViewHolder extends RecyclerView.ViewHolder{

    TextView mTextView;

    public RecyclerViewSimpleTextViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.first_name);
    }

    public TextView getTextView() {
        return mTextView;
    }

    public void setTextView(TextView textView) {
        mTextView = textView;
    }
}
