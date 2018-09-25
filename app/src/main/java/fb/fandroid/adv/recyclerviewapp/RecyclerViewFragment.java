    package fb.fandroid.adv.recyclerviewapp;


    import android.os.Bundle;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    /**
     * Created by andrew on 22.09.2018.
     */
    //http://qaru.site/questions/619746/what-is-the-best-way-to-save-state-of-recyclerview


    public class RecyclerViewFragment extends BaseFragment {
        private RecyclerView mRecyclerView;
        private LinearLayoutManager mLayoutManager;
        //Recycler View будет в этом фрагменте
        //В моем фрагменте я переопределяю методы и сохраняю состояние mLayoutManager
        // data object we want to retain

        //looking for how to make RecyclerView in a Fragment

        //https://www.google.com/search?q=Recyclerview+in+fragmnet&ie=utf-8&oe=utf-8&client=firefox-b-ab


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle   savedInstanceState) {
            super.onCreate(savedInstanceState);
            View view  = inflater.inflate(R.layout.activity_main, container, false);
            initInstances(view);
            setRetainInstance(true);
            return view;
        }

        private void initInstances(View view) {
            mRecyclerView = (RecyclerView) view.findViewById(R.id.rvContacts);
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
         //   adapter = new MyAdapter(items);
           // mRecyclerView.setAdapter(mAdapter);
        }        
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }

        @Override
        protected void onSaveState(Bundle outState) {
            super.onSaveState(outState);
            outState.putParcelable("myState", mLayoutManager.onSaveInstanceState());
        }

        @Override
        protected void onRestoreState(Bundle savedInstanceState) {
            super.onRestoreState(savedInstanceState);
            mLayoutManager.onRestoreInstanceState(savedInstanceState.getParcelable("myState"));
        }
    }