package com.scottmobleyschreibman.agecalculator;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class AgeInputActivity extends Activity {



    private EditText textDay;
    private EditText textMonth;
    private EditText textYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_input);

        textDay = (EditText) findViewById(R.id.enterDay);
        textMonth = (EditText) findViewById(R.id.enterMonth);
        textYear = (EditText) findViewById(R.id.enterYear);
        final RadioGroup ageChoice = (RadioGroup)findViewById(R.id.ageChoice);
        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDay.setText("");
                textMonth.setText("");
                textYear.setText("");
                ageChoice.clearCheck();


            }

        });

    }
    public void OnRadioButtonClicked(View view) {
        int year = Integer.parseInt(textYear.getText().toString());
        int month = Integer.parseInt(textMonth.getText().toString());
        int day = Integer.parseInt(textDay.getText().toString());

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButtonDay:
                if (checked)
                    Toast.makeText(this, "You are  "+ (String.valueOf(convertToDays(getAge(year, month, day)))) + "  days old", Toast.LENGTH_LONG).show();

                break;
            case R.id.radioButtonWeek:
                if (checked)
                    Toast.makeText(this, "You are  "+ (String.valueOf(convertToWeeks(getAge(year, month, day))))+ "  weeks old", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButtonMonth:
                if (checked)
                    Toast.makeText(this, "You are  "+ (String.valueOf(convertToMonths(getAge(year, month, day))))+ "  months old", Toast.LENGTH_LONG).show();
                break;
        }

    }

    public double getAge(int DOByear, int DOBmonth, int DOBday) {

        double age;

        final Calendar calendarToday = Calendar.getInstance();
        int currentYear = calendarToday.get(Calendar.YEAR);
        int currentMonth = 1 + calendarToday.get(Calendar.MONTH);
        int todayDay = calendarToday.get(Calendar.DAY_OF_MONTH);

        age = (((currentYear - DOByear)*365)+ ((currentYear - DOByear)/4))+ ((((currentMonth-1)*(365.25/12))+todayDay)- (((DOBmonth-1)*(365.25/12))+ DOBday));

        if(DOBmonth > currentMonth || DOBmonth == currentMonth)
        { --age;
            if(DOBday > todayDay && DOBmonth == currentMonth)
            { --age; }}

        return age;

    }

    private double convertToDays (double getAge) {
        return (getAge);
    }

    private double convertToWeeks(double getAge) {
        return ((getAge/365)*52);
    }

    private double convertToMonths(double getAge) {
        return ((getAge/365) *12);
    }




}
