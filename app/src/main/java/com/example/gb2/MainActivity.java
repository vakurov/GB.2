package com.example.gb2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonDot;
    Button buttonEqual;
    Button buttonDivide;
    Button buttonMultiply;
    Button buttonSubtract;
    Button buttonAdd;
    Button buttonClear;
    EditText editText;
    TextView infoTextView;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char CURRENT_ACTION;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DecimalFormat decimalFormat = new DecimalFormat("#.##########");

        init();

        buttonOne.setOnClickListener(view -> editText.setText(editText.getText() + "1"));
        buttonTwo.setOnClickListener(view -> editText.setText(editText.getText() + "2"));
        buttonThree.setOnClickListener(view -> editText.setText(editText.getText() + "3"));
        buttonFour.setOnClickListener(view -> editText.setText(editText.getText() + "4"));
        buttonFive.setOnClickListener(view -> editText.setText(editText.getText() + "5"));
        buttonSix.setOnClickListener(view -> editText.setText(editText.getText() + "6"));
        buttonSeven.setOnClickListener(view -> editText.setText(editText.getText() + "7"));
        buttonEight.setOnClickListener(view -> editText.setText(editText.getText() + "8"));
        buttonNine.setOnClickListener(view -> editText.setText(editText.getText() + "9"));
        buttonZero.setOnClickListener(view -> editText.setText(editText.getText() + "0"));
        buttonDot.setOnClickListener(view -> editText.setText(editText.getText() + "."));

        buttonClear.setOnClickListener(view -> {
            if(editText.getText().length() > 0) {
                CharSequence currentText = editText.getText();
                editText.setText(currentText.subSequence(0, currentText.length()-1));
            }
            else {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                editText.setText("");
                infoTextView.setText("");
            }
        });

        buttonAdd.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = ADDITION;
            infoTextView.setText(decimalFormat.format(valueOne) + " + ");
            editText.setText(null);
        });
        buttonSubtract.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = SUBTRACTION;
            infoTextView.setText(decimalFormat.format(valueOne) + " - ");
            editText.setText(null);
        });
        buttonMultiply.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = MULTIPLICATION;
            infoTextView.setText(decimalFormat.format(valueOne) + " * ");
            editText.setText(null);
        });
        buttonDivide.setOnClickListener(view -> {
            computeCalculation();
            CURRENT_ACTION = DIVISION;
            infoTextView.setText(decimalFormat.format(valueOne) + " / ");
            editText.setText(null);
        });
        buttonEqual.setOnClickListener(view -> {
            computeCalculation();
            infoTextView.setText(infoTextView.getText().toString() +
                    decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
            valueOne = Double.NaN;
            CURRENT_ACTION = '0';
        });


    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);
            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            }
            catch (Exception e){
                Toast.makeText(this, "Что-то пошло не так...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void init() {

        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonZero = findViewById(R.id.buttonZero);
        buttonDot = findViewById(R.id.buttonDot);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        editText = findViewById(R.id.editText);
        infoTextView = findViewById(R.id.infoTextView);

    }

}