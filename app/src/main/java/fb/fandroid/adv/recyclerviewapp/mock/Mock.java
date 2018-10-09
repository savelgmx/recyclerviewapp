package fb.fandroid.adv.recyclerviewapp.mock;

/**
 * Created by Administrator on 09.10.2018.
 * класс фиктивных данных для наполнения ресайклер вью
 */

public class Mock {

    private String mName;

    private int mValue;

    public Mock(String name, int value) {
        mName = name;
        mValue = value;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getValue() {
        return String.valueOf(mValue);
    }

    public void setValue(int value) {
        mValue = value;
    }
}
