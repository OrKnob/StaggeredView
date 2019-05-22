package com.example.arnavjha.staggeredview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Linear extends AppCompatActivity {

    Button B1,B2,B3,B4,B5,B6,B7,B8,B9,B0,bDec,bAdd,bSub,bMul,bDiv,bEqu,bCle,bHis;

    EditText result;
    TextView HIS;
    public static TextView line;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private DecimalFormat decimalFormat;
    private char CURRENT_ACTION;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    String s;
    String index;
    String j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        names();
        Listners();
        decimalFormat = new DecimalFormat("#.##########");
    }

    public void names(){

        result = findViewById(R.id.Result);
        B1 = findViewById(R.id.button1);
        B2 = findViewById(R.id.button2);
        B3 = findViewById(R.id.button3);
        B4 = findViewById(R.id.button4);
        B5 = findViewById(R.id.button5);
        B6 = findViewById(R.id.button6);
        B7 = findViewById(R.id.button7);
        B8 = findViewById(R.id.button8);
        B9 = findViewById(R.id.button9);
        B0 = findViewById(R.id.button0);
        bDec = findViewById(R.id.button10);
        bAdd = findViewById(R.id.add);
        bSub = findViewById(R.id.subtract);
        bMul = findViewById(R.id.multiply);
        bDiv = findViewById(R.id.divide);
        bEqu = findViewById(R.id.equals);
        bCle = findViewById(R.id.Clear);
        HIS = findViewById(R.id.his);


    }

    public void ClickResponse(){
        bAdd.setClickable(false);
        bSub.setClickable(false);
        bMul.setClickable(false);
        bDiv.setClickable(false);
        bDec.setClickable(false);
    }

    public void ClickResponses(){
        bAdd.setClickable(true);
        bSub.setClickable(true);
        bMul.setClickable(true);
        bDiv.setClickable(true);

    }

    public void Listners(){

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
                ClickResponses();
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
                ClickResponses();
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
                ClickResponses();
            }
        });

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
                ClickResponses();
            }
        });

        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
                ClickResponses();
            }
        });

        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
                ClickResponses();
            }
        });

        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
                ClickResponses();
            }
        });

        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
                ClickResponses();
            }
        });

        B9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "9");
                ClickResponses();
            }
        });


        B0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "0");
                ClickResponses();
            }
        });

        bDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + ".");
                ClickResponse();
            }
        });

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calculate();
                CURRENT_ACTION = ADDITION;
                result.setText(null);
                ClickResponse();
                bDec.setClickable(true);

            }
        });

        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calculate();
                CURRENT_ACTION = SUBTRACTION;
                result.setText(null);
                ClickResponse();
                bDec.setClickable(true);
            }
        });

        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calculate();
                CURRENT_ACTION = MULTIPLICATION;
                result.setText(null);
                ClickResponse();
                bDec.setClickable(true);
            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calculate();
                CURRENT_ACTION = DIVISION;
                result.setText(null);
                ClickResponse();
                bDec.setClickable(true);
            }
        });

        bEqu.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Calculate();
                result.setText(decimalFormat.format(valueOne));
                s = new String(result.getText().toString());
                HIS.setText(HIS.getText().toString() + s + "   ");





                valueOne = Double.NaN;
                CURRENT_ACTION = '0';

            }
        });

        bCle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().length() > 0) {
                    result.setText(" ");
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    result.setText("");
                    result.setText("");
                }
                HIS.setText(" ");
            }
        });


    }

    public void Calculate(){
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(result.getText().toString());

            result.setText(null);

            if(CURRENT_ACTION == ADDITION) {
                valueOne = this.valueOne + valueTwo;
            }

            else if(CURRENT_ACTION == SUBTRACTION){
                valueOne = this.valueOne - valueTwo;
            }
            else if(CURRENT_ACTION == MULTIPLICATION) {
                valueOne = this.valueOne * valueTwo;

            }
            else if(CURRENT_ACTION == DIVISION) {
                valueOne = this.valueOne / valueTwo;
            }
        }

        else{
            try{
                valueOne = Double.parseDouble(result.getText().toString());
            }
            catch (Exception e){}
        }

    }
}
