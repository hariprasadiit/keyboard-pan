package in.vizmo.keyboardpan;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by hari on 04/10/17.
 */

public class MainFragment extends Fragment implements View.OnFocusChangeListener {


    LinearLayout ll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main,container,false);
        ll = (LinearLayout) v.findViewById(R.id.views);
        // EVent if dont set SOFT_INPUT_MODE, system automatically selecting either SOFT_INPUT_ADJUST_RESIZE or SOFT_INPUT_ADJUST_PAN based on the content.
        // try running project without setting it
        // there's no official way to listen for keyboard open/hide events. dirty ways are there but might not work in all situation.
        // we can just go ahead with setting soft input mode for now
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        addViews();
        return v;
    }

    private void addViews() {
        for(int i=0;i < 20; i++){
            EditText et = new EditText(getActivity());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0,0,0,convertToPx(15));
            et.setLayoutParams(lp);
            et.setHint("Enter something "+i);
            et.setOnFocusChangeListener(this);
            ll.addView(et);
        }
    }

    public int convertToPx(int dp) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * scale + 0.5f);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }
}
