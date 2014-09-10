package com.sidwyn.ageconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AgeConverter extends Activity {

    public enum EarthDays {
        MERCURY(87.96, 0.378),
        VENUS(224.68, 0.907),
        EARTH(365.26, 0.166),
        MARS(686.96, 0.377),
        JUPITER(11.862, 2.364),
        SATURN(29.456, 0.916),
        URANUS(84.07, 0.889),
        NEPTUNE(164.81, 1.125);


        private final double days;
        private final double weight;

        EarthDays(double days, double weight) {
            this.days = days;
            this.weight = weight;
        }

        public double getDays() {
            return days;
        }

        public double getWeight() {
            return weight;
        }

    }

    private EditText userAge;
    private EditText userWeight;
    private Button convertButton;
    private TextView mercuryAge, mercuryWeight;
    private TextView venusAge, venusWeight;
    private TextView earthAge, earthWeight;
    private TextView marsAge, marsWeight;
    private TextView jupiterAge, jupiterWeight;
    private TextView saturnAge, saturnWeight;
    private TextView uranusAge, uranusWeight;
    private TextView neptuneAge, neptuneWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_converter);


        addListenerOnButton();
    }

    public void addListenerOnButton() {

        convertButton = (Button) findViewById(R.id.convertButton);

        userAge = (EditText) findViewById(R.id.ageField);
        userWeight = (EditText) findViewById(R.id.weightField);

        earthAge = (TextView) findViewById(R.id.earthAge);
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
                if (userAgeString.length() == 0) {
                    Toast.makeText(AgeConverter.this, R.string.missing_age, Toast.LENGTH_SHORT).show();
                    return;
                }
                float userAgeFloat = Float.parseFloat(userAgeString);

                String userWeightString = userWeight.getText().toString();
                if (userWeightString.length() == 0) {
                    Toast.makeText(AgeConverter.this, R.string.missing_weight, Toast.LENGTH_SHORT).show();
                    return;
                }
                float userWeightFloat = Float.parseFloat(userWeightString);

                if (userAgeFloat <= 0) {
                    Toast.makeText(AgeConverter.this, R.string.incorrect_age, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userWeightFloat <= 0) {
                    Toast.makeText(AgeConverter.this, R.string.incorrect_weight, Toast.LENGTH_SHORT).show();
                    return;
                }

                // Earth
                String originalString = String.format("%.2f years, %.2f kg", userAgeFloat, userWeightFloat);
                earthAge.setText(originalString);

                // Mercury
                double mercuryCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.MERCURY.getDays();
                double mercuryWeightCalculation = userWeightFloat * EarthDays.MERCURY.getWeight();
                String formattedString = String.format("%.2f years, %.2f kg", mercuryCalculation, mercuryWeightCalculation);

                mercuryAge.setText(formattedString);

                // Venus
                double venusCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.VENUS.getDays();
                double venusWeightCalculation = userWeightFloat * EarthDays.VENUS.getWeight();
                String formattedString2 = String.format("%.2f years, %.2f kg", venusCalculation, venusWeightCalculation);
                venusAge.setText(formattedString2);

                // Mars
                double marsCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.MARS.getDays();
                double marsWeightCalculation = userWeightFloat * EarthDays.MARS.getWeight();
                String formattedString3 = String.format("%.2f years, %.2f kg", marsCalculation, marsWeightCalculation);
                marsAge.setText(formattedString3);

                // Jupiter
                double jupiterCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.JUPITER.getDays();
                double jupiterWeightCalculation = userWeightFloat * EarthDays.JUPITER.getWeight();
                String formattedString4 = String.format("%.2f years, %.2f kg", jupiterCalculation, jupiterWeightCalculation);
                jupiterAge.setText(formattedString4);

                // Saturn
                double saturnCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.SATURN.getDays();
                double saturnWeightCalculation = userWeightFloat * EarthDays.SATURN.getWeight();
                String formattedString5 = String.format("%.2f years, %.2f kg", saturnCalculation, saturnWeightCalculation);
                saturnAge.setText(formattedString5);

                // Uranus
                double uranusCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.URANUS.getDays();
                double uranusWeightCalculation = userWeightFloat * EarthDays.URANUS.getWeight();
                String formattedString6 = String.format("%.2f years, %.2f kg", uranusCalculation, uranusWeightCalculation);
                uranusAge.setText(formattedString6);

                // Neptune
                double neptuneCalculation = userAgeFloat * EarthDays.EARTH.getDays() / EarthDays.NEPTUNE.getDays();
                double neptuneWeightCalculation = userWeightFloat * EarthDays.NEPTUNE.getWeight();
                String formattedString7 = String.format("%.2f years, %.2f kg", neptuneCalculation, neptuneWeightCalculation);
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
