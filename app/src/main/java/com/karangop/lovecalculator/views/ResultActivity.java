package com.karangop.lovecalculator.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.karangop.lovecalculator.R;
import com.karangop.lovecalculator.models.Love;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rlresult);
        relativeLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        TextView name1 = (TextView) findViewById(R.id.txtFirstName);
        TextView name2 = (TextView) findViewById(R.id.txtSecondName);
        TextView percentage = (TextView) findViewById(R.id.txtPercentage);

        Love love = (Love) getIntent().getSerializableExtra(MainActivity.LOVE);

        name1.setText(love.getFname().toUpperCase());
        name2.setText(love.getSname().toUpperCase());

        String percent = String.format(getResources().getString(R.string.percent_result), love.getPercentage(),"%");
        percentage.setText(percent);
    }
}
