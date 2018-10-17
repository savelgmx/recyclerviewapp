package fb.fandroid.adv.recyclerviewapp.mFragments;


import android.content.ContentUris;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.service.voice.VoiceInteractionService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import fb.fandroid.adv.recyclerviewapp.R;
import fb.fandroid.adv.recyclerviewapp.mRecycler.ContactsAdapter;
import fb.fandroid.adv.recyclerviewapp.mock.MockAdapter;
import fb.fandroid.adv.recyclerviewapp.mock.MockGenerator;


/**
 * Created by Administrator on 08.10.2018.
 */

public class RecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,LoaderManager.LoaderCallbacks<Cursor>{

    private RecyclerView mRecycler;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //private final MockAdapter mMockAdapter=new MockAdapter();

    private final ContactsAdapter mContactsAdapter = new ContactsAdapter();
    private View mErrorView;
    private Random mRandom = new Random();

    /*
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new SimpleRVAdapter(strings));
        return rv;
 */

    public static RecyclerFragment newInstance() {
     return new RecyclerFragment();
     }
    @Nullable
    @Override



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
     }

    @Override
 public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mRecycler = view.findViewById(R.id.recycler);
        mSwipeRefreshLayout = view.findViewById(R.id.refresher);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mErrorView=view.findViewById(R.id.error_view);

         }


@Override
    public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
   // mRecycler.setAdapter(mMockAdapter);
    mRecycler.setAdapter(mContactsAdapter);
}


    @Override
    public void onRefresh() {
/*
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = mRandom.nextInt( 4);
                if (count==0){
                    showError();
                }
                 else{
                    showData(count);
                }

                 if (mSwipeRefreshLayout.isRefreshing()){
                    mSwipeRefreshLayout.setRefreshing(false);
                }

            }
        },2000);
*/

    getLoaderManager().restartLoader(0,null,this);//иницыализируем Лоадер


    }

//    private void showData(int count) {
//        mMockAdapter.addData(MockGenerator.generate(4),true);
//        mErrorView.setVisibility(View.GONE);
//        mRecycler.setVisibility(View.VISIBLE);
//
//    }
//
//    private void showError() {
//        mErrorView.setVisibility(View.VISIBLE);
//        mRecycler.setVisibility(View.GONE);
//
//    }
//

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new CursorLoader(getActivity(),
                ContactsContract.Contacts.CONTENT_URI,
                new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME},
                null,
                null,
                ContactsContract.Contacts._ID
        );
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

        mContactsAdapter.swapCursor(data);

        if (mSwipeRefreshLayout.isRefreshing()){//мы еще и убираем индикатор загрузки в SwipeRefreshLayout.
            mSwipeRefreshLayout.setRefreshing(false);
        }



    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}


