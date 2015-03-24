package com.scottmobleyschreibman.agecalculator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Owner on 12/5/2014.
 */
public class CalculateActivity extends Activity {

    private static final String TAG = CalculateActivity.class.getSimpleName();
    private TextView Calculate;
    private String Age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Intent intent = getIntent();
        Age = intent.getStringExtra("age");

        Log.d(TAG, Age);

        Calculate = (TextView) findViewById(R.id.ageTextView);
        showAge();
    }
    private void showAge(){





       Toast.makeText(this, Age, Toast.LENGTH_LONG).show();
    }


}
