package com.sidwyn.ageconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class AgeConverter extends Activity {

    public enum EarthDays {
        MERCURY(87.96),
        VENUS(224.68),
        EARTH(365.26),
        MARS(686.96),
        JUPITER(11.862),
        SATURN(29.456),
        URANUS(84.07),
        NEPTUNE(164.81);


        private final double days;
        EarthDays(double days) {
            this.days = days;
        }

        public double getDays() {
            return days;
        }

    }

    private EditText userAge;
    private Button convertButton;
    private TextView mercuryAge;
    private TextView venusAge;
    private TextView earthAge;
    private TextView marsAge;
    private TextView jupiterAge;
    private TextView saturnAge;
    private TextView uranusAge;
    private TextView neptuneAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_converter);


        addListenerOnButton();
    }

    public void addListenerOnButton() {

        convertButton = (Button) findViewById(R.id.convertButton);

        userAge = (EditText) findViewById(R.id.ageField);
        mercuryAge = (TextView) findViewById(R.id.mercuryAge);
        venusAge = (TextView) findViewById(R.id.venusAge);
        marsAge = (TextView) findViewById(R.id.marsAge);
        jupiterAge = (TextView) findViewById(R.id.jupiterAge);
        saturnAge = (TextView) findViewById(R.id.saturnAge);
        uranusAge = (TextView) findViewById(R.id.uranusAge);
        neptuneAge = (TextView) findViewById(R.id.neptuneAge);

        convertButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String userAgeString = userAge.getText().toString();
                float userAgeFloat = Float.parseFloat(userAgeString);

                double mercuryCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.MERCURY.getDays();
                String formattedString = String.format("%.2f years", mercuryCalculation);
                mercuryAge.setText(formattedString);

                double venusCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.VENUS.getDays();
                String formattedString2 = String.format("%.2f years", venusCalculation);
                venusAge.setText(formattedString2);

                double marsCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.MARS.getDays();
                String formattedString3 = String.format("%.2f years", marsCalculation);
                marsAge.setText(formattedString3);

                double jupiterCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.JUPITER.getDays();
                String formattedString4 = String.format("%.2f years", jupiterCalculation);
                jupiterAge.setText(formattedString4);

                double saturnCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.SATURN.getDays();
                String formattedString5 = String.format("%.2f years", saturnCalculation);
                saturnAge.setText(formattedString5);

                double uranusCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.URANUS.getDays();
                String formattedString6 = String.format("%.2f years", uranusCalculation);
                uranusAge.setText(formattedString6);

                double neptuneCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.NEPTUNE.getDays();
                String formattedString7 = String.format("%.2f years", neptuneCalculation);
                neptuneAge.setText(formattedString7);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.age_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
