import android.content.Context;
import android.util.AttributeSet;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.lang.reflect.Field;

public class NSearchableSpinner extends SearchableSpinner {
    public NSearchableSpinner(Context context) {
        super(context);
    }

    public NSearchableSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NSearchableSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void clearSelection(){
        try {
            Field isDirty = SearchableSpinner.class.getDeclaredField("_isDirty");
            isDirty.setAccessible(true);
            isDirty.set(this,false);
            //重新加载Adapter以刷新hintText(目前没找到更好的办法)
            var adapter = getAdapter();
            setAdapter(adapter);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
