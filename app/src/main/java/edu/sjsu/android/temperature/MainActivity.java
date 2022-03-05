package edu.sjsu.android.temperature;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText text;
    TextView finalResult;
//to commit accident
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
        finalResult = (TextView) findViewById(R.id.textView2);
    }

    public float getText(){
        float inputValue = Float.parseFloat(text.getText().toString());
        return inputValue;
    }

    public float insuranceCalculated() {
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if (checkBox.isChecked()) {
            checkBox.setChecked(true);
            float inputValue = Float.parseFloat(text.getText().toString());
            return (float) (inputValue * 0.1);
        } else {
            return 0;
        }
    }


    public float getInterest() {
        SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
        int seekValue = seek.getProgress();
        float interest = ((seekValue / 1200) * 100);
        return interest;
    }

    public int getMonths() {
        int months = 0;
       // switch (view.getId()) {
       //     case R.id.button:
                RadioButton fifteenYears =
                        (RadioButton) findViewById(R.id.radioButton);
                RadioButton twentyYears =
                        (RadioButton) findViewById(R.id.radioButton2);
                RadioButton thirtyYears =
                        (RadioButton) findViewById(R.id.radioButton3);


                // float inputValue = Float.parseFloat(text.getText().toString());
                if (fifteenYears.isChecked()) {
                    // text.setText(String
                    //      .valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    months = 15;
                    twentyYears.setChecked(false);
                    thirtyYears.setChecked(false);
                    fifteenYears.setChecked(true);
                } else if (twentyYears.isChecked()) {
                    // text.setText(String
                    //   .valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    months = 20;
                    fifteenYears.setChecked(false);
                    thirtyYears.setChecked(false);
                    twentyYears.setChecked(true);
                } else {
                    fifteenYears.setChecked(false);
                    thirtyYears.setChecked(true);
                    twentyYears.setChecked(false);
                    months = 30;
                }

        //}
        return months;


    }

    public void onClick(View view) {
        MainActivity test = new MainActivity();
        Bundle temp = new Bundle();
        test.onCreate(temp);
        float insurance = test.insuranceCalculated();
        float interest = test.getInterest();
        int months = test.getMonths();
        float textInput = test.getText();
        float result = ConverterUtil.calculate(textInput, interest, months, insurance);

        String monthlyResult = Float.toString(result);
        finalResult.setText(monthlyResult);
    }
}

