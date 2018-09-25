    package fb.fandroid.adv.recyclerviewapp;


    import android.os.Bundle;
    import android.support.v4.app.Fragment;

    /**
     * Created by andrew on 22.09.2018.
     */
    //http://qaru.site/questions/619746/what-is-the-best-way-to-save-state-of-recyclerview


    public class RecyclerViewFragment extends Fragment {
        //Recycler View будет в этом фрагменте для ого чтобы
        // data object we want to retain

        Bundle savedState;

        public RecyclerViewFragment() {
            super();
            if (getArguments() == null)
                setArguments(new Bundle());
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            if (!restoreStateFromArguments()) {
                onFirstTimeLaunched();
            }
        }

        protected void onFirstTimeLaunched() {

        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            saveStateToArguments();
        }


        public void saveStateToArguments() {
            if (getView() != null)
                savedState = saveState();
            if (savedState != null) {
                Bundle b = getArguments();
                b.putBundle("internalSavedViewState8954201239547", savedState);
            }
        }

        private boolean restoreStateFromArguments() {
            Bundle b = getArguments();
            savedState = b.getBundle("internalSavedViewState8954201239547");
            if (savedState != null) {
                onRestoreState(savedState);
                return true;
            }
            return false;
        }

        private Bundle saveState() {
            Bundle state = new Bundle();
            onSaveState(state);
            return state;
        }

        protected void onRestoreState(Bundle savedInstanceState) {

        }

        protected void onSaveState(Bundle outState) {

        }

        @Override
        public void onStart() {
            super.onStart();
        }

        @Override
        public void onStop() {
            super.onStop();
        }


        @Override
        public void onDestroyView() {
            super.onDestroyView();
            saveStateToArguments();

        }
    }