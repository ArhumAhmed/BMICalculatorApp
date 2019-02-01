package com.ahmed.bmicalculator;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    TextView bmi;
    Spinner spinner;  //Create Spinner object for dropdown
    ArrayAdapter<CharSequence> adapter;
    private AdView mAdView; //Ad object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmi=findViewById(R.id.bmiOutput);
        //Ads
        MobileAds.initialize(this, "ca-app-pub-3011145604783069~6795661224");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //Dropdown Spinner
        spinner=findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.units,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)   //Switch case to determine which period is selected
                {
                    case 0:   //Imperial selected

                        break;
                    case 1:   //Metric Selected

                        break;

                    default:   // Should never occur, but if so, treat as imperial
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void calculate(View v)
    {
        //Define views
        TextView bmi=findViewById(R.id.bmiOutput);
        EditText weight = findViewById(R.id.weight);
        EditText feet=findViewById((R.id.feet));
        EditText inches=findViewById(R.id.inches);
        //Category Views
        TextView cat1=findViewById(R.id.cat1);
        TextView cat2=findViewById(R.id.cat2);
        TextView cat3=findViewById(R.id.cat3);
        TextView cat4=findViewById(R.id.cat4);
        TextView cat5=findViewById(R.id.cat5);
        TextView cat6=findViewById(R.id.cat6);
        TextView cat7=findViewById(R.id.cat7);
        TextView cat8=findViewById(R.id.cat8);
        //Range Views
        TextView range1=findViewById(R.id.range1);
        TextView range2=findViewById(R.id.range2);
        TextView range3=findViewById(R.id.range3);
        TextView range4=findViewById(R.id.range4);
        TextView range5=findViewById(R.id.range5);
        TextView range6=findViewById(R.id.range6);
        TextView range7=findViewById(R.id.range7);
        TextView range8=findViewById(R.id.range8);
        //View for keeping color
        TextView category = findViewById(R.id.catView);
        ColorStateList oldColors =  category.getTextColors();
        //Extract inputs as Strings
        String weightTemp = weight.getText().toString(); //Weight
        String feetTemp= feet.getText().toString(); //Feet
        String inchesTemp = inches.getText().toString(); //Inches

        //Verify no blank inputs
        if (weightTemp.matches("")) //If nothing inputted for weight, display warning toast
        {
            Toast.makeText(getApplicationContext(),"Enter a number for weight!",Toast.LENGTH_SHORT).show();
        }

        else if (feetTemp.matches("")) //If nothing inputted for feet, display warning toast
        {
            Toast.makeText(getApplicationContext(),"Enter a number for feet!",Toast.LENGTH_SHORT).show();
        }

        else  //All fields are valid
        {
            //If inches field empty, set to default 0
            if (inchesTemp.matches("")) //If nothing inputted for inches, set to 0
            {
                inchesTemp="0";
            }

            //Parse inputs as their proper data type
            double weightNum= Double.parseDouble(weightTemp); //Weight
            int inchesNum = Integer.parseInt(feetTemp); //Feet
            inchesNum *=12; //Feet to inches
            inchesNum += Integer.parseInt(inchesTemp); //Add inches to inchesNum

            //Determining BMI
            double bmiCalc = 703.0 * weightNum;
            bmiCalc /= (inchesNum*inchesNum);
            bmi.setText(String.format("%.1f", bmiCalc));


            //Reset any changed textviews back to original colors
            cat1.setTextColor(oldColors);
            cat2.setTextColor(oldColors);
            cat3.setTextColor(oldColors);
            cat4.setTextColor(oldColors);
            cat5.setTextColor(oldColors);
            cat6.setTextColor(oldColors);
            cat7.setTextColor(oldColors);
            cat8.setTextColor(oldColors);
            range1.setTextColor(oldColors);
            range2.setTextColor(oldColors);
            range3.setTextColor(oldColors);
            range4.setTextColor(oldColors);
            range5.setTextColor(oldColors);
            range6.setTextColor(oldColors);
            range7.setTextColor(oldColors);
            range8.setTextColor(oldColors);



            //Change color of selected category and BMI range to pink
            if (bmiCalc<16.0)
            {
                cat1.setTextColor(Color.parseColor("#FFD81B60"));
                range1.setTextColor(Color.parseColor("#FFD81B60"));
            }

            else if (bmiCalc >= 16.0 && bmiCalc <17.0)
            {
                cat2.setTextColor(Color.parseColor("#FFD81B60"));
                range2.setTextColor(Color.parseColor("#FFD81B60"));
            }

            else if (bmiCalc >= 17.0 && bmiCalc < 18.5)
            {
                cat3.setTextColor(Color.parseColor("#FFD81B60"));
                range3.setTextColor(Color.parseColor("#FFD81B60"));
            }

            else if (bmiCalc >= 18.5 && bmiCalc <25.0)
            {
                cat4.setTextColor(Color.parseColor("#FFD81B60"));
                range4.setTextColor(Color.parseColor("#FFD81B60"));
            }

            else if (bmiCalc >=25.0 && bmiCalc < 30.0)
            {
                cat5.setTextColor(Color.parseColor("#FFD81B60"));
                range5.setTextColor(Color.parseColor("#FFD81B60"));
            }

            else if (bmiCalc >=30.0 && bmiCalc < 35.0)
            {
                cat6.setTextColor(Color.parseColor("#FFD81B60"));
                range6.setTextColor(Color.parseColor("#FFD81B60"));
            }

            else if (bmiCalc >=35.0 && bmiCalc <40.0)
            {
                cat7.setTextColor(Color.parseColor("#FFD81B60"));
                range7.setTextColor(Color.parseColor("#FFD81B60"));
            }

            else
            {
                cat8.setTextColor(Color.parseColor("#FFD81B60"));
                range8.setTextColor(Color.parseColor("#FFD81B60"));
            }
        }



    }
}
