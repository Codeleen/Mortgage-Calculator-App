package edu.sjsu.android.temperature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
    }

    public void onClick(View view){
     switch (view.getId()) {
        case R.id.button:
            RadioButton celsiusButton =
                    (RadioButton) findViewById(R.id.radioButton);
            RadioButton fahrenheitButton =
                    (RadioButton) findViewById(R.id.radioButton2);
            if (text.getText().length() == 0) {
                Toast.makeText(this, "Please enter a valid number",
                        Toast.LENGTH_LONG).show();
                return;
            }
            float inputValue = Float.parseFloat(text.getText().toString());
            if (celsiusButton.isChecked()) {
                text.setText(String
                        .valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                celsiusButton.setChecked(false);
                fahrenheitButton.setChecked(true);
            } else {
                text.setText(String
                        .valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                fahrenheitButton.setChecked(false);
                celsiusButton.setChecked(true);
            }
            break;
    }
}

}