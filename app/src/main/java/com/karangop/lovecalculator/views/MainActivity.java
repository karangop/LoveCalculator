package com.karangop.lovecalculator.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.karangop.lovecalculator.R;
import com.karangop.lovecalculator.models.Love;
import com.karangop.lovecalculator.network.GetCalculation;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainCallback {

    public static final String LOVE = "com.karangop.lovecalculator.KEY.LOVE";
    private EditText name1;
    private EditText name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout root = (LinearLayout) findViewById(R.id.llRoot);
        root.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        name1 = (EditText) findViewById(R.id.EtFname);
        name2 = (EditText) findViewById(R.id.EtSname);

        name2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE) {
                    getResult();
                    return true;
                }
                return false;
            }
        });

        Button buttonCal = (Button) findViewById(R.id.btnCalculate);

        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResult();
            }
        });

    }

    private void getResult() {
        //fn-->fname // sn-->sname
        String fn = name1.getText().toString();
        String sn = name2.getText().toString();

        new NameValidation(MainActivity.this).validate(fn, sn);

    }

    @Override
    public void fnameValidate() {
        Toast.makeText(MainActivity.this, R.string.validate_name1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void snameValidate() {
        Toast.makeText(MainActivity.this, R.string.validate_name2, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(Map<String, String> queryMap) {
        name1.setText("");
        name2.setText("");
        new Result().execute(queryMap);
    }

    private class Result extends GetCalculation {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Love love) {

            if (love != null) {
                /*example
                TextView textView = (TextView) findViewById(R.id.result);
                textView.setText(love.getFname());*/


                /*Intent intent= new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("percentage",love.getPercentage());*/

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra(LOVE, love);
                startActivity(intent);

            } else {
                Toast.makeText(MainActivity.this, "Fallo", Toast.LENGTH_SHORT).show();
            }
            progressDialog.dismiss();
        }
    }
}
