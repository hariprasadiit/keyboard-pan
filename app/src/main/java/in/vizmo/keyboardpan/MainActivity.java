package in.vizmo.keyboardpan;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.container);

        getFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();
    }

}
