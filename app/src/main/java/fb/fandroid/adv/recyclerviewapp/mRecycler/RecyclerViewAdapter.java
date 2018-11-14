package fb.fandroid.adv.recyclerviewapp.mRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fb.fandroid.adv.recyclerviewapp.R;
import fb.fandroid.adv.recyclerviewapp.User;
import fb.fandroid.adv.recyclerviewapp.ViewHolderTypeOne;
import fb.fandroid.adv.recyclerviewapp.ViewHolderTypeTwo;
import fb.fandroid.adv.recyclerviewapp.mFragments.RecyclerFragment;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    public static final int USER = 0;
    public static final int IMAGE = 1;

    private List<Object> mItems;

    public RecyclerViewAdapter(List<Object> items) {
        this.mItems = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case USER:
                View v1 = inflater.inflate(R.layout.item_view_holder_1, parent, false);
                viewHolder = new ViewHolderTypeOne(v1);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.item_view_holder_2, parent, false);
                viewHolder = new ViewHolderTypeTwo(v2);
                break;
            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                viewHolder = new ViewHolderTypeOne(v);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(position);
            }
        });

        switch (holder.getItemViewType()) {
            case USER:
                ViewHolderTypeOne vh1 = (ViewHolderTypeOne) holder;
                configureViewHolderOne(vh1, position);
                break;
            case IMAGE:
                ViewHolderTypeTwo vh2 = (ViewHolderTypeTwo) holder;
                configureViewHolderTwo(vh2, position);
                break;
            default:
                RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) holder;
                configureDefaultViewHolder(vh, position);
                break;
        }
    }

    private void configureDefaultViewHolder(RecyclerViewSimpleTextViewHolder vh, int position) {
        vh.getTextView().setText((CharSequence) mItems.get(position));
    }

    private void configureViewHolderTwo(ViewHolderTypeTwo vh2, int position) {
        vh2.getImageView().setImageResource(R.drawable.kingsharbour);
    }

    private void configureViewHolderOne(ViewHolderTypeOne vh1, int position) {
        User user = (User) mItems.get(position);
        if (user != null) {
            vh1.getFirstName().setText("Name: " + user.getFirstName());
            vh1.getSecondName().setText("Last Name: " + user.getSecondName());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position) instanceof User) {
            return USER;
        } else if (mItems.get(position) instanceof String) {
            return IMAGE;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItem(RecyclerFragment context, int type) {
        switch (type) {
            case IMAGE:
                mItems.add("image");
                notifyItemInserted(mItems.size());
                break;
            case USER:
                mItems.add(new User("Test", "Test"));
                notifyItemInserted(mItems.size());
                break;
            default:
                 break;
        }
    }

    public void deleteItem(int position) {
        mItems.remove(position);
        notifyDataSetChanged();
    }


}
