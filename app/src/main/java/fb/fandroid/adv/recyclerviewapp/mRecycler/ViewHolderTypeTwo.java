package fb.fandroid.adv.recyclerviewapp.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import fb.fandroid.adv.recyclerviewapp.R;

public class ViewHolderTypeTwo extends RecyclerView.ViewHolder {

    private ImageView mImageView;

    public ViewHolderTypeTwo(View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView);
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        mImageView = imageView;
    }
}
